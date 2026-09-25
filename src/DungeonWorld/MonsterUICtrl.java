package DungeonWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MonsterUICtrl extends UICtrl{
    private Monster monster;
    private MonsterEditor monsterEditor;
    private ConfirmationUI confirmationUI;
    private JDialog confirmationDialog;

    public MonsterUICtrl(Monster monster){
        this.monster = monster;
        frame = new JFrame();
        monsterEditor = new MonsterEditor(this);
        frame.setTitle("Monster Editor");
        frame.setContentPane(monsterEditor.getcPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,1000);
        frame.setLocationRelativeTo(null);
        ResetValues(true);

        monsterEditor.getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResetValues(false);
            }

        });

        monsterEditor.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearValues();
            }
        });

        monsterEditor.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveValues();
            }
        });

        monsterEditor.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteMonster();
            }
        });



        frame.setVisible(true);

    }
        //Clears the shown values to their default states
    public void ClearValues(){
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this,"Are you sure you want to clear the current data?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600,200);
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

        //Resets values shown to the saved values in the object
    public void ResetValues(boolean skipConfirmation){
        if(skipConfirmation){
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
        else{
            confirmationDialog = new JDialog();
            confirmationDialog.setModal(true);
            confirmationUI = new ConfirmationUI(this, "Are you sure you want to reset the current data to the saved values?");
            confirmationDialog.setContentPane(confirmationUI.getcPanel());
            confirmationDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            confirmationDialog.setSize(600, 200);
            confirmationDialog.setLocationRelativeTo(null);

            confirmationUI.getYesButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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
        //TODO: Saves the shown values to a database or local file somewhere
    //Saves the current written data to the object
    public void SaveValues(){
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this,"Are you sure you want to save and overwrite the current data?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600,200);
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
                for(int i = 0; i < tempMoveList.getSize(); i++){
                    tempMoves.add(tempMoveList.getElementAt(i));
                }
                monster.setMoves(tempMoves);
                ArrayList<Item> tempItems = new ArrayList<Item>();
                ListModel<Item> tempItemList = monsterEditor.getItemList().getModel();
                for(int i = 0; i < tempItemList.getSize(); i++){
                    tempItems.add(tempItemList.getElementAt(i));
                }
                monster.setItems(tempItems);
                ArrayList<DWTag> tempTags = new ArrayList<DWTag>();
                ListModel<DWTag> tempTagList = monsterEditor.getTagList().getModel();
                for(int i = 0; i < tempTagList.getSize(); i++){
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
        //TODO: Deletes the object from a database or local file
    public void DeleteMonster(){
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this,"Are you sure you want to delete this monster and all the current data?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600,200);
        confirmationDialog.setLocationRelativeTo(null);


        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationDialog.dispose();
                //TODO: Remove monster from the list.(After data can be saved somewhere, json or something)
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
