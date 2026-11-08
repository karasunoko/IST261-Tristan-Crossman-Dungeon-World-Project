package DungeonWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CharacterUICtrl extends UICtrl {
    private ArrayList<Character> characters;
    private Character character;
    private CharacterEditor characterEditor;
    private ConfirmationUI confirmationUI;
    private JDialog confirmationDialog;
    private ArrayList<Listable> newList;

    private CharacterUICtrl() {
    }

    public static CharacterUICtrl forCharacter(ArrayList<Character> characters, Character character) {
        CharacterUICtrl ctrl = new CharacterUICtrl();
        ctrl.characters = characters;
        ctrl.character = character;
        ctrl.characterEditor = new CharacterEditor(ctrl);
        return ctrl;
    }

    public CharacterEditor getCharacterEditor() {
        return characterEditor;
    }

    //Clears the shown values to their default states
    public void ClearValues() {
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure you want to clear the current data?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterEditor.getNameText().setText("");
                characterEditor.getInstinctText().setText("");
                characterEditor.getSpecialText().setText("");
                characterEditor.getDescriptionText().setText("");
                characterEditor.getMoveList().setListData(new ArrayList<Move>().toArray());
                characterEditor.getItemList().setListData(new ArrayList<Item>().toArray());
                characterEditor.getTagList().setListData(new ArrayList<DWTag>().toArray());
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

    private void showSavedValues() {
        characterEditor.getNameText().setText(character.getName());
        characterEditor.getInstinctText().setText(character.getInstinct());
        characterEditor.getSpecialText().setText(character.getSpecial());
        characterEditor.getDescriptionText().setText(character.getDescription());
        characterEditor.getMoveList().setListData(character.getMoves().toArray());
        characterEditor.getItemList().setListData(character.getItems().toArray());
        characterEditor.getTagList().setListData(character.getTags().toArray());
    }

    //Resets values shown to the saved values in the object
    public void ResetValues(boolean skipConfirmation) {
        if (skipConfirmation) {
            showSavedValues();
        } else {
            confirmationDialog = new JDialog();
            confirmationDialog.setModal(true);
            confirmationUI = new ConfirmationUI(this, "Are you sure you want to reset the current data to the saved values?");
            confirmationDialog.setContentPane(confirmationUI.getcPanel());
            confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            confirmationDialog.setSize(600, 200);
            confirmationDialog.setLocationRelativeTo(null);

            confirmationUI.getYesButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showSavedValues();
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
    }

    //Saves the shown values to the object
    public void SaveValues() {
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure you want to save and overwrite the current data?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.setName(characterEditor.getNameText().getText());
                character.setInstinct(characterEditor.getInstinctText().getText());
                character.setSpecial(characterEditor.getSpecialText().getText());
                character.setDescription(characterEditor.getDescriptionText().getText());
                ArrayList<Move> tempMoves = new ArrayList<Move>();
                ListModel<Move> tempMoveList = characterEditor.getMoveList().getModel();
                for (int i = 0; i < tempMoveList.getSize(); i++) {
                    tempMoves.add(tempMoveList.getElementAt(i));
                }
                character.setMoves(tempMoves);
                ArrayList<Item> tempItems = new ArrayList<Item>();
                ListModel<Item> tempItemList = characterEditor.getItemList().getModel();
                for (int i = 0; i < tempItemList.getSize(); i++) {
                    tempItems.add(tempItemList.getElementAt(i));
                }
                character.setItems(tempItems);
                ArrayList<DWTag> tempTags = new ArrayList<DWTag>();
                ListModel<DWTag> tempTagList = characterEditor.getTagList().getModel();
                for (int i = 0; i < tempTagList.getSize(); i++) {
                    tempTags.add(tempTagList.getElementAt(i));
                }
                character.setTags(tempTags);
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

    //Removes the character from the list and closes the editor
    public void DeleteValues() {
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure you want to delete this character and all the current data?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characters.remove(character);
                confirmationDialog.dispose();
                frame.dispose();
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

    //Opens the menu to edit the list of moves
    public void EditMoves() {
        ListUICtrl moveUICtrl = ListUICtrl.forMoves(character.getMoves());
        moveUICtrl.setFrame(new JFrame());
        moveUICtrl.getFrame().setTitle("Move Editor");
        moveUICtrl.getFrame().setContentPane(moveUICtrl.getMoveEditor().getcPane());
        moveUICtrl.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        moveUICtrl.getFrame().setSize(600, 500);
        moveUICtrl.getFrame().pack();
        moveUICtrl.getFrame().setLocationRelativeTo(null);
        moveUICtrl.getFrame().setVisible(true);
        moveUICtrl.ResetValues(true);
        moveUICtrl.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                showSavedValues();
            }
        });
        MoveEditor ed = moveUICtrl.getMoveEditor();
        ed.getPreviousButton().addActionListener(e -> moveUICtrl.PreviousValues());
        ed.getNextButton().addActionListener(e -> moveUICtrl.NextValues());
        ed.getResetButton().addActionListener(e -> moveUICtrl.ResetValues(false));
        ed.getSaveButton().addActionListener(e -> moveUICtrl.SaveValues());
        ed.getClearButton().addActionListener(e -> moveUICtrl.ClearValues());
        ed.getDeleteButton().addActionListener(e -> moveUICtrl.DeleteValues());
        ed.getNewButton().addActionListener(e -> moveUICtrl.New());
        ed.getSaveAndCloseButton().addActionListener(e -> {
            newList = moveUICtrl.SaveClose();
            ArrayList<Move> newMoves = new ArrayList<Move>();
            for (Listable l : newList) {
                newMoves.add((Move) l);
            }
            character.setMoves(newMoves);
        });
    }

    //Opens the menu to edit the list of items
    public void EditItems() {
        ListUICtrl itemUICtrl = ListUICtrl.forItems(character.getItems());
        itemUICtrl.setFrame(new JFrame());
        itemUICtrl.getFrame().setTitle("Item Editor");
        itemUICtrl.getFrame().setContentPane(itemUICtrl.getItemEditor().getcPane());
        itemUICtrl.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        itemUICtrl.getFrame().setSize(600, 500);
        itemUICtrl.getFrame().pack();
        itemUICtrl.getFrame().setLocationRelativeTo(null);
        itemUICtrl.getFrame().setVisible(true);
        itemUICtrl.ResetValues(true);
        itemUICtrl.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                showSavedValues();
            }
        });
        ItemEditor ed = itemUICtrl.getItemEditor();
        ed.getPreviousButton().addActionListener(e -> itemUICtrl.PreviousValues());
        ed.getNextButton().addActionListener(e -> itemUICtrl.NextValues());
        ed.getResetButton().addActionListener(e -> itemUICtrl.ResetValues(false));
        ed.getSaveButton().addActionListener(e -> itemUICtrl.SaveValues());
        ed.getClearButton().addActionListener(e -> itemUICtrl.ClearValues());
        ed.getDeleteButton().addActionListener(e -> itemUICtrl.DeleteValues());
        ed.getNewButton().addActionListener(e -> itemUICtrl.New());
        ed.getEditTagsButton().addActionListener(e -> itemUICtrl.EditTags());
        ed.getSaveAndCloseButton().addActionListener(e -> {
            newList = itemUICtrl.SaveClose();
            ArrayList<Item> newItems = new ArrayList<Item>();
            for (Listable l : newList) {
                newItems.add((Item) l);
            }
            character.setItems(newItems);
        });
    }

    //Opens the menu to edit the list of tags
    public void EditTags() {
        ListUICtrl tagUICtrl = ListUICtrl.forTags(character.getTags());
        tagUICtrl.setFrame(new JFrame());
        tagUICtrl.getFrame().setTitle("Tag Editor");
        tagUICtrl.getFrame().setContentPane(tagUICtrl.getTagEditor().getcPane());
        tagUICtrl.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tagUICtrl.getFrame().setSize(600, 500);
        tagUICtrl.getFrame().pack();
        tagUICtrl.getFrame().setLocationRelativeTo(null);
        tagUICtrl.getFrame().setVisible(true);
        tagUICtrl.ResetValues(true);
        tagUICtrl.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                showSavedValues();
            }
        });
        TagEditor ed = tagUICtrl.getTagEditor();
        ed.getPreviousButton().addActionListener(e -> tagUICtrl.PreviousValues());
        ed.getNextButton().addActionListener(e -> tagUICtrl.NextValues());
        ed.getResetButton().addActionListener(e -> tagUICtrl.ResetValues(false));
        ed.getSaveButton().addActionListener(e -> tagUICtrl.SaveValues());
        ed.getClearButton().addActionListener(e -> tagUICtrl.ClearValues());
        ed.getDeleteButton().addActionListener(e -> tagUICtrl.DeleteValues());
        ed.getNewButton().addActionListener(e -> tagUICtrl.New());
        ed.getSaveAndCloseButton().addActionListener(e -> {
            newList = tagUICtrl.SaveClose();
            ArrayList<DWTag> newTags = new ArrayList<DWTag>();
            for (Listable l : newList) {
                newTags.add((DWTag) l);
            }
            character.setTags(newTags);
        });
    }
}