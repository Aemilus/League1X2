package app.league1x2.gui.panels.tickets.table;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.Bet;
import app.league1x2.core.BetTicket;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TicketTableModel extends AbstractTableModel {
    private final String[] columnNames = {
            LeagueAppConstants.GAME,
            LeagueAppConstants.SELECTION,
            LeagueAppConstants.ODDS,
    };
    private final ArrayList<Bet> data = new ArrayList<>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bet bet = data.get(rowIndex);
        if (columnIndex == 0) {
            return bet.getName();
        } else if (columnIndex == 1) {
            return bet.getSelection();
        } else {
            return bet.getOdd();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setData(BetTicket betTicket) {
        data.clear();
        if (betTicket != null) {
            data.addAll(betTicket.getBets());
        }
    }

}
