package app.league1x2.gui.panels.tickets;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.gui.panels.tickets.navigate.TicketsNavigationPanel;
import app.league1x2.gui.panels.tickets.stats.TicketsStatsPanel;
import app.league1x2.gui.panels.tickets.table.TicketTablePanel;

import javax.swing.*;
import java.awt.*;

public class TicketsRootPanel extends JPanel {
    public final TicketsStatsPanel ticketsStatsPanel = new TicketsStatsPanel();
    public final TicketTablePanel ticketTablePanel = new TicketTablePanel();
    public final TicketsNavigationPanel ticketsNavigationPanel= new TicketsNavigationPanel();

    public TicketsRootPanel() {
        setLayout(new BorderLayout(5, 5));
        add(ticketsStatsPanel, BorderLayout.NORTH);
        add(ticketTablePanel, BorderLayout.CENTER);
        add(ticketsNavigationPanel, BorderLayout.SOUTH);
    }
}
