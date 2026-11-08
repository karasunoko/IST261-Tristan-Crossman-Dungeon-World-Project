package DungeonWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MonsterUICtrl extends UICtrl {
    private ArrayList<Character> characters;
    private Monster monster;
    private MonsterEditor monsterEditor;
    private ConfirmationUI confirmationUI;
    private JDialog confirmationDialog;
    private ArrayList<Listable> newList;

    private MonsterUICtrl() {
    }

    public static MonsterUICtrl forMonster(ArrayList<Character> characters, Monster monster) {
        MonsterUICtrl ctrl = new MonsterUICtrl();
        ctrl.characters = characters;
        ctrl.monster = monster;
        ctrl.monsterEditor = new MonsterEditor(ctrl);
        return ctrl;
    }

    public MonsterEditor getMonsterEditor() {
        return monsterEditor;
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
                monsterEditor.getNameText().setText("");
                monsterEditor.getWeaponText().setText("");
                monsterEditor.getRangeText().setText("");
                monsterEditor.getInstinctText().setText("");
                monsterEditor.getSpecialText().setText("");
                monsterEditor.getHpSpinner().setValue(0);
                monsterEditor.getArmorSpinner().setValue(0);
                monsterEditor.getDescriptionText().setText("");
                monsterEditor.getMoveList().setListData(new ArrayList<Move>().toArray());
                monsterEditor.getItemList().setListData(new ArrayList<Item>().toArray());
                monsterEditor.getTagList().setListData(new ArrayList<DWTag>().toArray());
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
        monsterEditor.getNameText().setText(monster.getName());
        monsterEditor.getWeaponText().setText(monster.getWeapon());
        monsterEditor.getRangeText().setText(monster.getRange());
        monsterEditor.getInstinctText().setText(monster.getInstinct());
        monsterEditor.getSpecialText().setText(monster.getSpecial());
        monsterEditor.getHpSpinner().setValue(monster.getHP());
        monsterEditor.getArmorSpinner().setValue(monster.getArmor());
        monsterEditor.getDescriptionText().setText(monster.getDescription());
        monsterEditor.getMoveList().setListData(monster.getMoves().toArray());
        monsterEditor.getItemList().setListData(monster.getItems().toArray());
        monsterEditor.getTagList().setListData(monster.getTags().toArray());
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

    //Saves the current written data to the object
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
                monster.setName(monsterEditor.getNameText().getText());
                monster.setWeapon(monsterEditor.getWeaponText().getText());
                monster.setHP(((Number) monsterEditor.getHpSpinner().getValue()).intValue());
                monster.setArmor(((Number) monsterEditor.getArmorSpinner().getValue()).intValue());
                monster.setRange(monsterEditor.getRangeText().getText());
                monster.setInstinct(monsterEditor.getInstinctText().getText());
                monster.setSpecial(monsterEditor.getSpecialText().getText());
                monster.setDescription(monsterEditor.getDescriptionText().getText());
                ArrayList<Move> tempMoves = new ArrayList<Move>();
                ListModel<Move> tempMoveList = monsterEditor.getMoveList().getModel();
                for (int i = 0; i < tempMoveList.getSize(); i++) {
                    tempMoves.add(tempMoveList.getElementAt(i));
                }
                monster.setMoves(tempMoves);
                ArrayList<Item> tempItems = new ArrayList<Item>();
                ListModel<Item> tempItemList = monsterEditor.getItemList().getModel();
                for (int i = 0; i < tempItemList.getSize(); i++) {
                    tempItems.add(tempItemList.getElementAt(i));
                }
                monster.setItems(tempItems);
                ArrayList<DWTag> tempTags = new ArrayList<DWTag>();
                ListModel<DWTag> tempTagList = monsterEditor.getTagList().getModel();
                for (int i = 0; i < tempTagList.getSize(); i++) {
                    tempTags.add(tempTagList.getElementAt(i));
                }
                monster.setTags(tempTags);
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

    //Removes the monster from the list and closes the editor
    public void DeleteValues() {
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure you want to delete this monster and all the current data?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characters.remove(monster);
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
        ListUICtrl moveUICtrl = ListUICtrl.forMoves(monster.getMoves());
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
            monster.setMoves(newMoves);
        });
    }

    //Opens the menu to edit the list of items
    public void EditItems() {
        ListUICtrl itemUICtrl = ListUICtrl.forItems(monster.getItems());
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
            monster.setItems(newItems);
        });
    }

    //Opens the menu to edit the list of tags
    public void EditTags() {
        ListUICtrl tagUICtrl = ListUICtrl.forTags(monster.getTags());
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
            monster.setTags(newTags);
        });
    }
}