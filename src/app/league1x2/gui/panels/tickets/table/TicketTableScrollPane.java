package app.league1x2.gui.panels.tickets.table;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;

public class TicketTableScrollPane extends JScrollPane {

    public TicketTableScrollPane(JTable ticketsTable) {
        super(ticketsTable);
        ticketsTable.setFillsViewportHeight(true);
        ticketsTable.getColumnModel().getColumn(0).
                setMinWidth(LeagueAppConstants.GAME_COLUMN_WIDTH);
    }
}
