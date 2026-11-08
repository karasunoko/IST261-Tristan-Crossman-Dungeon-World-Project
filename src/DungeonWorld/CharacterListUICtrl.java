package DungeonWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CharacterListUICtrl extends UICtrl {
    private ArrayList<Character> characters;
    private CharacterTableModel characterTableModel;
    private CharacterListUI characterListUI;
    private ConfirmationUI confirmationUI;
    private JDialog confirmationDialog;

    public CharacterListUICtrl(ArrayList<Character> characters) {
        this.characters = characters;
        characterTableModel = new CharacterTableModel(characters);
        characterListUI = new CharacterListUI(this);
        frame = characterListUI;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> StorageManager.saveCharacters(this.characters)));
        characterListUI.setVisible(true);
    }

    public CharacterTableModel getCharacterTableModel() {
        return characterTableModel;
    }

    public Character getCharacter(int index) {
        return characters.get(index);
    }

    //Asks which type to create, adds it to the list, and opens its editor
    public void newCharacter() {
        String[] types = {"Character", "Monster", "Hireling"};
        int choice = JOptionPane.showOptionDialog(characterListUI,
                "What type of character do you want to create?", "New Character",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, types, types[0]);
        if (choice < 0) return;

        Character newCharacter;
        switch (choice) {
            case 1:
                newCharacter = new Monster("New Monster", 1);
                break;
            case 2:
                newCharacter = new Hireling("New Hireling");
                break;
            default:
                newCharacter = new Character("New Character");
                break;
        }
        if (newCharacter.getInstinct() == null) newCharacter.setInstinct("");
        if (newCharacter.getSpecial() == null) newCharacter.setSpecial("");

        characters.add(newCharacter);
        characterTableModel.fireTableDataChanged();
        openEditor(characters.size() - 1);
    }

    public void deleteCharacter(int row) {
        Character character = characters.get(row);
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure you want to delete " + character.getName() + "?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characters.remove(character);
                characterTableModel.fireTableDataChanged();
                confirmationDialog.dispose();
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationDialog.dispose();
            }
        });
        confirmationDialog.setVisible(true);
    }

    //Opens the editor that matches the character's type
    public void openEditor(int row) {
        Character character = characters.get(row);
        JFrame editorFrame;
        if (character instanceof Monster) {
            editorFrame = buildMonsterEditor((Monster) character);
        } else {
            editorFrame = buildCharacterEditor(character); // Hireling uses this too for now
        }

        editorFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                characterTableModel.fireTableDataChanged();
                characterListUI.setVisible(true);
            }
        });

        characterListUI.setVisible(false);
        editorFrame.setVisible(true);
    }

    private JFrame buildCharacterEditor(Character character) {
        CharacterUICtrl ctrl = CharacterUICtrl.forCharacter(characters, character);
        ctrl.setFrame(new JFrame());
        JFrame f = ctrl.getFrame();
        f.setTitle("Character Editor");
        f.setContentPane(ctrl.getCharacterEditor().getcPane());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500, 800);
        f.setLocationRelativeTo(null);
        ctrl.ResetValues(true);

        CharacterEditor ed = ctrl.getCharacterEditor();
        ed.getResetButton().addActionListener(e -> ctrl.ResetValues(false));
        ed.getClearButton().addActionListener(e -> ctrl.ClearValues());
        ed.getSaveButton().addActionListener(e -> ctrl.SaveValues());
        ed.getDeleteButton().addActionListener(e -> ctrl.DeleteValues());
        ed.getEditMovesButton().addActionListener(e -> ctrl.EditMoves());
        ed.getEditItemsButton().addActionListener(e -> ctrl.EditItems());
        ed.getEditTagsButton().addActionListener(e -> ctrl.EditTags());
        return f;
    }

    private JFrame buildMonsterEditor(Monster monster) {
        MonsterUICtrl ctrl = MonsterUICtrl.forMonster(characters, monster);
        ctrl.setFrame(new JFrame());
        JFrame f = ctrl.getFrame();
        f.setTitle("Monster Editor");
        f.setContentPane(ctrl.getMonsterEditor().getcPane());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500, 800);
        f.setLocationRelativeTo(null);
        ctrl.ResetValues(true);

        MonsterEditor ed = ctrl.getMonsterEditor();
        ed.getResetButton().addActionListener(e -> ctrl.ResetValues(false));
        ed.getClearButton().addActionListener(e -> ctrl.ClearValues());
        ed.getSaveButton().addActionListener(e -> ctrl.SaveValues());
        ed.getDeleteButton().addActionListener(e -> ctrl.DeleteValues());
        ed.getEditMovesButton().addActionListener(e -> ctrl.EditMoves());
        ed.getEditItemsButton().addActionListener(e -> ctrl.EditItems());
        ed.getEditTagsButton().addActionListener(e -> ctrl.EditTags());
        return f;
    }
}