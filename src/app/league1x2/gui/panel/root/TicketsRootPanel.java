package app.league1x2.gui.panel.root;

import app.league1x2.gui.panel.display.DisplayTicketPanel;
import app.league1x2.gui.panel.display.TicketsNavigationPanel;

import javax.swing.*;
import java.awt.*;

public class TicketsRootPanel extends JPanel {
    public final DisplayTicketPanel displayTicketPanel = new DisplayTicketPanel();
    public final TicketsNavigationPanel ticketsNavigationPanel= new TicketsNavigationPanel();

    public TicketsRootPanel() {
        setPreferredSize(new Dimension(350, 100));
        setLayout(new BorderLayout(5, 5));
        add(displayTicketPanel, BorderLayout.CENTER);
        add(ticketsNavigationPanel, BorderLayout.SOUTH);
    }
}
