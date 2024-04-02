package app.league1x2.gui.panel.display;

import app.league1x2.gui.panel.display.filter.FilterTicketsPanel;

import javax.swing.*;
import java.awt.*;

public class DisplayTicketPanel extends JPanel {
    public final FilterTicketsPanel filterTicketsPanel = new FilterTicketsPanel();
    public final TicketTablePanel ticketTablePanel = new TicketTablePanel();

    public DisplayTicketPanel() {
        setLayout(new BorderLayout(5, 5));
        add(filterTicketsPanel, BorderLayout.NORTH);
        add(ticketTablePanel, BorderLayout.CENTER);
    }

}
