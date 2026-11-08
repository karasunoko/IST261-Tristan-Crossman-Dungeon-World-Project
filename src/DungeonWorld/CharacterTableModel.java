package DungeonWorld;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CharacterTableModel extends AbstractTableModel {

    private String[] columns = {"Name", "Type", "Instinct", "Description"};
    private ArrayList<Character> list;

    public CharacterTableModel(ArrayList<Character> list) {
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
        Character c = list.get(row);
        switch (col) {
            case 0:
                return c.getName();
            case 1:
                return c.getClass().getSimpleName(); // Character, Monster, or Hireling
            case 2:
                return c.getInstinct();
            case 3:
                return c.getDescription();
            default:
                return null;
        }
    }
}