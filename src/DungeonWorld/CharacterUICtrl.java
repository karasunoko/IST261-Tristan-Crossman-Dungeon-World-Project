package DungeonWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CharacterUICtrl extends UICtrl{
    private DungeonWorld.Character character;
    private CharacterEditor characterEditor;
    private ConfirmationUI confirmationUI;
    private JFrame confirmationFrame;

    public CharacterUICtrl(Character character){
        this.character = character;
        frame = new JFrame();
        characterEditor = new CharacterEditor(this);

        frame.setTitle("Character Editor");
        frame.setContentPane(characterEditor.getcPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,1000);
        frame.setLocationRelativeTo(null);
        ResetValues(true);

        characterEditor.getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResetValues(false);
            }

        });

        characterEditor.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearValues();
            }
        });

        characterEditor.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveValues();
            }
        });

        characterEditor.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteCharacter();
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
                characterEditor.getNameText().setText("");
                characterEditor.getInstinctText().setText("");
                characterEditor.getSpecialText().setText("");
                characterEditor.getDescriptionText().setText("");
                characterEditor.getMoveList().setListData(new ArrayList<Move>().toArray());
                characterEditor.getItemList().setListData(new ArrayList<Item>().toArray());
                characterEditor.getTagList().setListData(new ArrayList<DWTag>().toArray());
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
    public void ResetValues(boolean skipConfirmation){
        if(skipConfirmation){
            characterEditor.getNameText().setText(character.getName());
            characterEditor.getInstinctText().setText(character.getInstinct());
            characterEditor.getSpecialText().setText(character.getSpecial());
            characterEditor.getDescriptionText().setText(character.getDescription());
            characterEditor.getMoveList().setListData(character.getMoves().toArray());
            characterEditor.getItemList().setListData(character.getItems().toArray());
            characterEditor.getTagList().setListData(character.getTags().toArray());
        }
        else {
            confirmationFrame = new JFrame();
            confirmationUI = new ConfirmationUI(this, "Are you sure you want to reset the current data to the saved values?");
            confirmationFrame.setContentPane(confirmationUI.getcPanel());
            confirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            confirmationFrame.setSize(600, 200);
            confirmationFrame.setLocationRelativeTo(null);
            confirmationFrame.setVisible(true);

            confirmationUI.getYesButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    characterEditor.getNameText().setText(character.getName());
                    characterEditor.getInstinctText().setText(character.getInstinct());
                    characterEditor.getSpecialText().setText(character.getSpecial());
                    characterEditor.getDescriptionText().setText(character.getDescription());
                    characterEditor.getMoveList().setListData(character.getMoves().toArray());
                    characterEditor.getItemList().setListData(character.getItems().toArray());
                    characterEditor.getTagList().setListData(character.getTags().toArray());
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
    }
    //Saves the shown values to the object
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

                character.setName(characterEditor.getNameText().getText());
                character.setInstinct(characterEditor.getInstinctText().getText());
                character.setSpecial(characterEditor.getSpecialText().getText());
                character.setDescription(characterEditor.getDescriptionText().getText());
                ArrayList<Move> tempMoves = new ArrayList<Move>();
                ListModel<Move> tempMoveList = characterEditor.getMoveList().getModel();
                for(int i = 0; i < tempMoveList.getSize(); i++){
                    tempMoves.add(tempMoveList.getElementAt(i));
                }
                character.setMoves(tempMoves);
                ArrayList<Item> tempItems = new ArrayList<Item>();
                ListModel<Item> tempItemList = characterEditor.getItemList().getModel();
                for(int i = 0; i < tempItemList.getSize(); i++){
                    tempItems.add(tempItemList.getElementAt(i));
                }
                character.setItems(tempItems);
                ArrayList<DWTag> tempTags = new ArrayList<DWTag>();
                ListModel<DWTag> tempTagList = characterEditor.getTagList().getModel();
                for(int i = 0; i < tempTagList.getSize(); i++){
                    tempTags.add(tempTagList.getElementAt(i));
                }
                character.setTags(tempTags);
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
    public void DeleteCharacter(){
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
                //TODO: Remove character from the list.(After data can be saved somewhere, json or something)
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
