package app.league1x2.gui.panels.tickets.filter;

import javax.swing.*;
import java.awt.*;

public class FilterTicketsControlPanel extends JPanel {
    public final JButton applyFilterTicketsButton = new JButton("Filtreaza");
    public final JButton resetFilterTicketsButton = new JButton("Reseteaza");

    public FilterTicketsControlPanel() {
        setLayout(new BorderLayout(5, 5));
        applyFilterTicketsButton.setFocusPainted(false);
        resetFilterTicketsButton.setFocusPainted(false);
        add(applyFilterTicketsButton, BorderLayout.WEST);
        add(resetFilterTicketsButton, BorderLayout.EAST);
    }
}
