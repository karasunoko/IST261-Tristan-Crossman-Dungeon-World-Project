import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MonsterUICtrl extends UICtrl{
    private Monster monster;
    private MonsterEditor monsterEditor;
    private ConfirmationUI confirmationUI;
    private JFrame confirmationFrame;

    public MonsterUICtrl(Monster monster){
        this.monster = monster;
        frame = new JFrame();
        monsterEditor = new MonsterEditor(this);

        frame.setTitle("Chungus UI");
        frame.setContentPane(monsterEditor.getcPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,1000);
        frame.setLocationRelativeTo(null);
        ResetValues();

        monsterEditor.getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResetValues();
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
        confirmationFrame = new JFrame();
        confirmationUI = new ConfirmationUI(this,"Are you sure you want to clear the current data?");
        confirmationFrame.setContentPane(confirmationUI.getcPanel());
        confirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmationFrame.setSize(600,200);
        confirmationFrame.setLocationRelativeTo(null);
        confirmationFrame.setVisible(true);


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
                confirmationFrame.dispose();
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationFrame.dispose();
            }
        });

    }

        //Resets values shown to the saved values in the object
    public void ResetValues(){
        confirmationFrame = new JFrame();
        confirmationUI = new ConfirmationUI(this,"Are you sure you want to reset the current data to the saved values?");
        confirmationFrame.setContentPane(confirmationUI.getcPanel());
        confirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmationFrame.setSize(600,200);
        confirmationFrame.setLocationRelativeTo(null);
        confirmationFrame.setVisible(true);

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
                confirmationFrame.dispose();
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationFrame.dispose();
            }
        });

    }
        //TODO: Saves the shown values to the object
    public void SaveValues(){
        confirmationFrame = new JFrame();
        confirmationUI = new ConfirmationUI(this,"Are you sure you want to save and overwrite the current data?");
        confirmationFrame.setContentPane(confirmationUI.getcPanel());
        confirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmationFrame.setSize(600,200);
        confirmationFrame.setLocationRelativeTo(null);
        confirmationFrame.setVisible(true);

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
                ArrayList<Item> tempItems = new ArrayList<Item>();
                ListModel<Item> tempItemList = monsterEditor.getItemList().getModel();
                for(int i = 0; i < tempItemList.getSize(); i++){
                    tempItems.add(tempItemList.getElementAt(i));
                }
                ArrayList<DWTag> tempTags = new ArrayList<DWTag>();
                ListModel<DWTag> tempTagList = monsterEditor.getTagList().getModel();
                for(int i = 0; i < tempTagList.getSize(); i++){
                    tempTags.add(tempTagList.getElementAt(i));
                }
                confirmationFrame.dispose();
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationFrame.dispose();
            }
        });

    }
        //TODO: Deletes the object
    public void DeleteMonster(){
        confirmationFrame = new JFrame();
        confirmationUI = new ConfirmationUI(this,"Are you sure you want to delete this monster and all the current data?");
        confirmationFrame.setContentPane(confirmationUI.getcPanel());
        confirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmationFrame.setSize(600,200);
        confirmationFrame.setLocationRelativeTo(null);
        confirmationFrame.setVisible(true);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationFrame.dispose();
                //TODO: Remove monster from the list.(After data can be saved somewhere, json or something)
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationFrame.dispose();
            }
        });
    }

}
