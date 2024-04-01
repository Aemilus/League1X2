package app.league1x2.gui.panel.display;

import javax.swing.*;
import java.awt.*;

public class TicketTablePanel extends JPanel {
    public final TicketTableModel ticketTableModel = new TicketTableModel(null);
    private final JTable betsTable = new JTable(ticketTableModel);
    private final TicketTableScrollPane ticketTableScrollPane = new TicketTableScrollPane(betsTable);

    public TicketTablePanel() {
        setLayout(new BorderLayout(5, 5));
        add(ticketTableScrollPane, BorderLayout.CENTER);
    }
}
