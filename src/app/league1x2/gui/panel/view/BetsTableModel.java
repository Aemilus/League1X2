package app.league1x2.gui.panel.view;

import app.league1x2.core.BetOdds;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BetsTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Meci", "1", "X", "2"};
    public final ArrayList<BetOdds> data = new ArrayList<>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BetOdds betOdds = data.get(rowIndex);
        if (columnIndex == 0) {
            return betOdds.getName();
        }
        else {
            return betOdds.getOdds().get(columnIndex - 1);
        }
    }

    public void addRow(BetOdds betOdds) {
        data.add(betOdds);
    }
}
