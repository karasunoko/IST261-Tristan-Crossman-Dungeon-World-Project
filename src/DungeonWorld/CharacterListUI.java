package DungeonWorld;

import javax.swing.*;
import java.awt.*;

public class CharacterListUI extends JFrame {
    private CharacterListUICtrl characterCtrl;
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable characterTable;
    private JScrollPane tableScroller;
    private JButton newButton;
    private JButton detailsButton;
    private JButton doneButton;

    public CharacterListUI(CharacterListUICtrl characterCtrl) {
        this.characterCtrl = characterCtrl;
        initComponents();
    }

    public void initComponents() {
        setTitle("Character List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 4));

        characterTable = new JTable(characterCtrl.getCharacterTableModel());
        characterTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        characterTable.getColumnModel().getColumn(0).setPreferredWidth(100); // Name
        characterTable.getColumnModel().getColumn(1).setPreferredWidth(70);  // Type
        characterTable.getColumnModel().getColumn(2).setPreferredWidth(120); // Instinct
        characterTable.getColumnModel().getColumn(3).setPreferredWidth(250); // Description

        newButton = new JButton("New");
        detailsButton = new JButton("Show Details");
        doneButton = new JButton("Done");

        newButton.addActionListener(e -> characterCtrl.newCharacter());
        detailsButton.addActionListener(e -> {
            int row = getSelectedModelRow();
            if (row >= 0) characterCtrl.openEditor(row);
        });
        doneButton.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);

        tableScroller = new JScrollPane(characterTable);
        characterTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(550, 300));
        tablePanel.add(tableScroller);

        setSize(650, 450);
        setLocationRelativeTo(null);
        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(tablePanel, BorderLayout.CENTER);
    }

    //Returns the selected row in the model, or -1 (with a message) if nothing is selected
    private int getSelectedModelRow() {
        int viewRow = characterTable.getSelectedRow();
        if (viewRow < 0) {
            JOptionPane.showMessageDialog(this, "Select a character in the table first.");
            return -1;
        }
        return characterTable.convertRowIndexToModel(viewRow);
    }

    public JTable getCharacterTable() {
        return characterTable;
    }
}