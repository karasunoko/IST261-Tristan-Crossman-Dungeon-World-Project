package DungeonWorld;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CharacterListUICtrl extends UICtrl{
        private ArrayList<Character> characterList;
        private CharacterListMenu characterListMenu;
        private ConfirmationUI confirmationUI;
        private JDialog confirmationDialog;


        CharacterListUICtrl(ArrayList<Character> characterList) {
            this.characterList = characterList;
            characterListMenu = new CharacterListMenu(this);
            frame = new JFrame();
            frame.setTitle("Character List");
            frame.setContentPane(characterListMenu.getcPane());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700,700);
            frame.setLocationRelativeTo(null);
            ResetValues(true);

            characterListMenu.getNewButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddCharacter();
                }
            });

            characterListMenu.getEditButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = characterListMenu.getCharacterDropdown().getSelectedIndex();
                    if (index >= 0) {
                        EditCharacter(characterListMenu.getModel().getElementAt(index));
                    }
                }
            });

            characterListMenu.getDeleteButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = characterListMenu.getCharacterDropdown().getSelectedIndex();
                    if (index >= 0) {
                        DeleteCharacter(characterListMenu.getModel().getElementAt(index));
                    }
                }
            });


            frame.setVisible(true);
        }

        public void ResetValues(boolean skipConfirmation){
            if(skipConfirmation){
                characterListMenu.getModel().removeAllElements();
                characterListMenu.getModel().addAll(characterList);
            }else{
                confirmationDialog = new JDialog();
                confirmationDialog.setModal(true);
                confirmationUI = new ConfirmationUI(this,"Are you sure you want to reset the character list?");
                confirmationDialog.setContentPane(confirmationUI.getcPanel());
                confirmationDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                confirmationDialog.setSize(600,200);
                confirmationDialog.setLocationRelativeTo(null);

                confirmationUI.getYesButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        characterListMenu.getModel().removeAllElements();
                        characterListMenu.getModel().addAll(characterList);
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


        public void DeleteCharacter(Character character){
            confirmationDialog = new JDialog();
            confirmationDialog.setModal(true);
            confirmationUI = new ConfirmationUI(this,"Are you sure you want to delete the selected character?");
            confirmationDialog.setContentPane(confirmationUI.getcPanel());
            confirmationDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            confirmationDialog.setSize(600,200);
            confirmationDialog.setLocationRelativeTo(null);

            confirmationUI.getYesButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    characterList.remove(character);
                    ResetValues(true);
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

        public void EditCharacter(Character character){
            confirmationDialog = new JDialog();
            confirmationDialog.setModal(true);
            confirmationUI = new ConfirmationUI(this,"Are you sure you want to edit the selected character?");
            confirmationDialog.setContentPane(confirmationUI.getcPanel());
            confirmationDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            confirmationDialog.setSize(600,200);
            confirmationDialog.setLocationRelativeTo(null);

            confirmationUI.getYesButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(character instanceof Monster){
                        MonsterUICtrl monsterUICtrl = new MonsterUICtrl((Monster) character);
                        frame.setVisible(false);
                        monsterUICtrl.getFrame().addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                    frame.setVisible(true);
                            }
                        });
                    } else if (character instanceof Hireling) {
                        //TODO: add Hireling UI functionality
                    }else {
                        CharacterUICtrl characterUICtrl = new CharacterUICtrl(character);
                        frame.setVisible(false);
                        characterUICtrl.getFrame().addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame.setVisible(true);
                            }
                        });
                    }

                    ResetValues(true);
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

    public void AddCharacter(){
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this,"Are you sure you want to add a new character?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600,200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResetValues(true);
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

        ResetValues(true);
    }
}

