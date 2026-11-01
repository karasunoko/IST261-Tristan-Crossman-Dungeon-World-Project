package DungeonWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemListUI extends JFrame {
    private ItemListUICtrl itemCtrl;
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable itemTable;
    private JScrollPane tableScroller;
    private JButton newButton;
    private JButton detailsButton;
    private JButton doneButton;

    public ItemListUI(ItemListUICtrl itemCtrl) {
        this.itemCtrl = itemCtrl;
        initComponents();
    }

    public void initComponents() {
        setTitle("Item List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 3));

        itemTable = new JTable(itemCtrl.getItemTableModel());
        itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemTable.getColumnModel().getColumn(0).setPreferredWidth(100); // Name
        itemTable.getColumnModel().getColumn(1).setPreferredWidth(250); // Desc
        itemTable.getColumnModel().getColumn(2).setPreferredWidth(30);  // n
        itemTable.getColumnModel().getColumn(3).setPreferredWidth(50);  // Weight
        itemTable.getColumnModel().getColumn(4).setPreferredWidth(50);  // Cost

        newButton = new JButton("New");
        detailsButton = new JButton("Show Details");
        doneButton = new JButton("Done");

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemCtrl.newItem();
            }
        });
        detailsButton.addActionListener(new DetailsButtonListener());
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });

        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);

        tableScroller = new JScrollPane(itemTable);
        itemTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(550, 300));
        tablePanel.add(tableScroller);

        setSize(650, 450);
        setLocationRelativeTo(null);
        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(tablePanel, BorderLayout.CENTER);
    }

    public JTable getItemTable() {
        return itemTable;
    }

    public class DetailsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int selectedTableRow = itemTable.getSelectedRow();
            int selectedModelRow = selectedTableRow < 0 ? -1 : itemTable.convertRowIndexToModel(selectedTableRow);

            if (selectedModelRow < 0) {
                selectedModelRow = 0;
            }
            if (itemCtrl.getItemTableModel().getRowCount() == 0) {
                return;
            }
            ItemListUI.this.itemCtrl.getItemDetailUI(selectedModelRow);
        }
    }
}