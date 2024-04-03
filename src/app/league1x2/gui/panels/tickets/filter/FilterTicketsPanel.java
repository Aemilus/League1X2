package app.league1x2.gui.panels.tickets.filter;

import javax.swing.*;
import java.awt.*;

public class FilterTicketsPanel extends JPanel {
    public final FilterTicketsInputPanel filterTicketsInputPanel = new FilterTicketsInputPanel();
    public final JButton filterTicketsButton = new JButton("Filtreaza");

    public FilterTicketsPanel() {
        setLayout(new BorderLayout(5, 5));
        filterTicketsButton.setFocusPainted(false);
        add(filterTicketsInputPanel, BorderLayout.CENTER);
        add(filterTicketsButton, BorderLayout.EAST);
    }

}
