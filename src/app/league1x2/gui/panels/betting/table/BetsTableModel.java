package app.league1x2.gui.panels.betting.table;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.betting.BetOdds;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BetsTableModel extends AbstractTableModel {
    private final String[] columnNames = {
            LeagueAppConstants.GAME,
            LeagueAppConstants.SELECTION_1,
            LeagueAppConstants.SELECTION_X,
            LeagueAppConstants.SELECTION_2,
    };
    public ArrayList<BetOdds> data = new ArrayList<>();

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
            return betOdds.name;
        }
        else {
            return betOdds.oddsMap.get(getColumnName(columnIndex));
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        BetOdds betOdds = data.get(rowIndex);
        if (columnIndex == 0) {
            betOdds.name = (String) aValue;
        } else {
            Double value;
            try {
                value = Double.parseDouble(((String) aValue).trim().replace(",", "."));
            } catch (NumberFormatException e) {
                value = Double.parseDouble("0.0");
            }

            betOdds.oddsMap.put(LeagueAppConstants.SELECTIONS[columnIndex - 1], value);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void addRow(BetOdds betOdds) {
        data.add(betOdds);
    }

    @SuppressWarnings("UnusedReturnValue")
    public BetOdds removeRow(int rowIndex) {
        return data.remove(rowIndex);
    }

}
