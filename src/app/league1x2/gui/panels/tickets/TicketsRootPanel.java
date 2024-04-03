package app.league1x2.gui.panels.tickets;

import app.league1x2.gui.panels.tickets.filter.FilterTicketsPanel;
import app.league1x2.gui.panels.tickets.navigate.TicketsNavigationPanel;
import app.league1x2.gui.panels.tickets.table.TicketTablePanel;

import javax.swing.*;
import java.awt.*;

public class TicketsRootPanel extends JPanel {
    public final FilterTicketsPanel filterTicketsPanel = new FilterTicketsPanel();
    public final TicketTablePanel ticketTablePanel = new TicketTablePanel();
    public final TicketsNavigationPanel ticketsNavigationPanel= new TicketsNavigationPanel();

    public TicketsRootPanel() {
        setPreferredSize(new Dimension(350, 100));
        setLayout(new BorderLayout(5, 5));
        add(filterTicketsPanel, BorderLayout.NORTH);
        add(ticketTablePanel, BorderLayout.CENTER);
        add(ticketsNavigationPanel, BorderLayout.SOUTH);
    }
}
