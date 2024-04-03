package app.league1x2.gui.panels.tickets.table;

import javax.swing.*;

public class TicketTableScrollPane extends JScrollPane {

    public TicketTableScrollPane(JTable ticketsTable) {
        super(ticketsTable);
        ticketsTable.setFillsViewportHeight(true);
        ticketsTable.getColumnModel().getColumn(0).setPreferredWidth(300);
    }
}