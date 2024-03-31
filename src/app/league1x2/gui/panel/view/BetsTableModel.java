package app.league1x2.gui.panel.view;

import app.league1x2.core.BetOdds;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BetsTableModel extends AbstractTableModel {
    private String[] columnNames = {"Meci", "1", "X", "2"};
    private ArrayList<BetOdds> data = new ArrayList<>();

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
        if (columnIndex == 1) {
            return betOdds.getOdd1();
        }
        if (columnIndex == 2) {
            return betOdds.getOddX();
        }
        if (columnIndex == 3) {
            return betOdds.getOdd2();
        }
        return null;
    }
}
