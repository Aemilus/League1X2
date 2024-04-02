package app.league1x2.gui.panel.view;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.BetOdds;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BetsTableModel extends AbstractTableModel {
    private final String[] columnNames = {
            LeagueAppConstants.GAME,
            LeagueAppConstants.SELECTION_1,
            LeagueAppConstants.SELECTION_X,
            LeagueAppConstants.SELECTION_2,
    };
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
            return betOdds.getOddsMap().get(getColumnName(columnIndex));
        }
    }

    public void addRow(BetOdds betOdds) {
        data.add(betOdds);
    }
}
