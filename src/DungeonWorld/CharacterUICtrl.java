package DungeonWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CharacterUICtrl extends UICtrl{
    private DungeonWorld.Character character;
    private CharacterEditor characterEditor;
    private ConfirmationUI confirmationUI;
    private JDialog confirmationDialog;
    private ArrayList<Listable> newList;

    public CharacterUICtrl(Character character){
        this.character = character;
        frame = new JFrame();
        characterEditor = new CharacterEditor(this);

        frame.setTitle("Character Editor");
        frame.setContentPane(characterEditor.getcPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,800);
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
        characterEditor.getEditMovesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditMoves();
            }
        });
        characterEditor.getEditItemsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditItems();
            }
        });
        characterEditor.getEditTagsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditTags();
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
                    characterEditor.getNameText().setText(character.getName());
                    characterEditor.getInstinctText().setText(character.getInstinct());
                    characterEditor.getSpecialText().setText(character.getSpecial());
                    characterEditor.getDescriptionText().setText(character.getDescription());
                    characterEditor.getMoveList().setListData(character.getMoves().toArray());
                    characterEditor.getItemList().setListData(character.getItems().toArray());
                    characterEditor.getTagList().setListData(character.getTags().toArray());
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
    public void DeleteCharacter(){
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
                //TODO: Remove character from the list.(After data can be saved somewhere, json or something)
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
    public void EditMoves(){
        ListUICtrl moveUICtrl = ListUICtrl.forMoves(character.getMoves());
        moveUICtrl.setFrame(new JFrame());
        moveUICtrl.getFrame().setTitle("Move Editor");

        moveUICtrl.getFrame().setContentPane(moveUICtrl.getMoveEditor().getcPane());
        moveUICtrl.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        moveUICtrl.getFrame().setSize(600,500);
        moveUICtrl.getFrame().setLocationRelativeTo(null);
        moveUICtrl.getFrame().setVisible(true);
        moveUICtrl.ResetValues(true);
        moveUICtrl.getFrame().addWindowListener(new WindowAdapter() {@Override public void windowClosed(WindowEvent e){ResetValues(true);}});
        moveUICtrl.getMoveEditor().getPreviousButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {moveUICtrl.PreviousValues();}});
        moveUICtrl.getMoveEditor().getNextButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {moveUICtrl.NextValues();}});
        moveUICtrl.getMoveEditor().getResetButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {moveUICtrl.ResetValues(false);}});
        moveUICtrl.getMoveEditor().getSaveButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {moveUICtrl.SaveValues();}});
        moveUICtrl.getMoveEditor().getClearButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {moveUICtrl.ClearValues();}});
        moveUICtrl.getMoveEditor().getDeleteButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {moveUICtrl.DeleteValues();}});
        moveUICtrl.getMoveEditor().getNewButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {moveUICtrl.New();}});
        moveUICtrl.getMoveEditor().getSaveAndCloseButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {newList = moveUICtrl.SaveClose();
            ArrayList<Move> newMoves = new ArrayList<Move>();
            for(Listable l : newList){
                newMoves.add((Move) l);
            }
            character.setMoves(newMoves);
        }});


    }

    public void EditItems(){
        ListUICtrl itemList = ListUICtrl.forItems(character.getItems());


    }

    public void EditTags(){
        ListUICtrl tagsList = ListUICtrl.forTags(character.getTags());


    }

}
