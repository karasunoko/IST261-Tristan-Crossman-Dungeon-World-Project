package DungeonWorld;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ItemListUICtrl extends UICtrl {
    private ArrayList<Item> items;
    private ItemTableModel itemTableModel;
    private ItemListUI itemListUI;
    private ListUICtrl itemDetailCtrl;

    public ItemListUICtrl(ArrayList<Item> items) {
        this.items = items;
        itemTableModel = new ItemTableModel(items);
        itemListUI = new ItemListUI(this);
        frame = itemListUI;
        itemListUI.setVisible(true);
    }

    public ItemTableModel getItemTableModel() {
        return itemTableModel;
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void newItem() {
        items.add(new Item("", ""));
        itemTableModel.fireTableDataChanged();
        getItemDetailUI(items.size() - 1);
    }

    public void getItemDetailUI(int selectedRow) {
        itemDetailCtrl = ListUICtrl.forItems(items);
        itemDetailCtrl.setFrame(new JFrame());
        JFrame detail = itemDetailCtrl.getFrame();
        detail.setTitle("Item Editor");
        detail.setContentPane(itemDetailCtrl.getItemEditor().getcPane());
        detail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detail.setSize(600, 500);
        detail.pack();
        detail.setLocationRelativeTo(null);

        itemDetailCtrl.setPosition(selectedRow);
        itemDetailCtrl.ResetValues(true);
        itemDetailCtrl.getItemEditor().getPreviousButton().setEnabled(selectedRow > 0);
        itemDetailCtrl.getItemEditor().getNextButton().setEnabled(selectedRow < items.size() - 1);

        ItemEditor ed = itemDetailCtrl.getItemEditor();
        ed.getPreviousButton().addActionListener(e -> itemDetailCtrl.PreviousValues());
        ed.getNextButton().addActionListener(e -> itemDetailCtrl.NextValues());
        ed.getResetButton().addActionListener(e -> itemDetailCtrl.ResetValues(false));
        ed.getSaveButton().addActionListener(e -> itemDetailCtrl.SaveValues());
        ed.getClearButton().addActionListener(e -> itemDetailCtrl.ClearValues());
        ed.getDeleteButton().addActionListener(e -> itemDetailCtrl.DeleteValues());
        ed.getNewButton().addActionListener(e -> itemDetailCtrl.New());
        ed.getEditTagsButton().addActionListener(e -> itemDetailCtrl.EditTags());
        ed.getSaveAndCloseButton().addActionListener(e -> itemDetailCtrl.SaveClose());

        detail.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                itemTableModel.fireTableDataChanged();
                itemListUI.setVisible(true);
            }
        });

        itemListUI.setVisible(false);
        detail.setVisible(true);
    }
}