package app.league1x2.gui.panels.tickets.table;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class TicketTablePanel extends JPanel {
    public final TicketTableModel ticketTableModel = new TicketTableModel();
    private final JTable betsTable = new JTable(ticketTableModel);
    private final TicketTableScrollPane ticketTableScrollPane = new TicketTableScrollPane(betsTable);

    public TicketTablePanel() {
        setLayout(new BorderLayout(5, 5));
        add(ticketTableScrollPane, BorderLayout.CENTER);
        betsTable.setRowHeight(LeagueAppConstants.TABLE_ROW_HEIGHT);
    }
}
