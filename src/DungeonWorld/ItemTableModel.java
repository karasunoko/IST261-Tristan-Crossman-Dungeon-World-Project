package DungeonWorld;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ItemTableModel extends AbstractTableModel {

    private String[] columns = {"Name", "Desc", "n", "Weight", "Cost"};
    private ArrayList<Item> list;

    public ItemTableModel(ArrayList<Item> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public Object getValueAt(int row, int col) {

        switch (col) {
            case 0:
                return (String) list.get(row).getName();
            case 1:
                return (String) list.get(row).getDescription();
            case 2:
                return (Number) list.get(row).getN();
            case 3:
                return (Number) list.get(row).getWeight();
            case 4:
                return (Number) list.get(row).getCost();
            default:
                return null;
        }

    }
}

