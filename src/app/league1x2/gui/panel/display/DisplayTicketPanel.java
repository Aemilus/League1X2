package app.league1x2.gui.panel.display;

import javax.swing.*;
import java.awt.*;

public class DisplayTicketPanel extends JPanel {
    public final JLabel ticketNameLabel = new JLabel("Ticket Label");
    public final TicketTablePanel ticketTablePanel = new TicketTablePanel();

    public DisplayTicketPanel() {
        setLayout(new BorderLayout(5, 5));
        add(ticketNameLabel, BorderLayout.NORTH);
        add(ticketTablePanel, BorderLayout.CENTER);
    }

}
