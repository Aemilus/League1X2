package app.league1x2.gui.panel.display;

import app.league1x2.core.Bet;
import app.league1x2.core.BetTicket;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TicketTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Meci", "Selectie", "Cota"};
    public final ArrayList<Bet> data = new ArrayList<>();

    public TicketTableModel(BetTicket betTicket) {
        if (betTicket != null) {
            data.addAll(betTicket.bets);
        }
    }

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
        } else {
            return bet.getOdd();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
