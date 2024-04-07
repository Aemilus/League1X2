package app.league1x2.gui.panels.filter.control;

import javax.swing.*;
import java.awt.*;

public class FilterTicketsControlPanel extends JPanel {
    public final JButton applyFilterTicketsButton = new JButton("Filtreaza");

    public FilterTicketsControlPanel() {
        setLayout(new BorderLayout(5, 5));
        applyFilterTicketsButton.setFocusPainted(false);
        add(applyFilterTicketsButton, BorderLayout.CENTER);
    }
}
