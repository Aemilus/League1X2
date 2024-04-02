package app.league1x2.gui.panel.control;

import javax.swing.*;
import java.awt.*;

public class BetsControlPanel extends JPanel {
    public final JButton generateTicketsButton = new JButton("Genereaza");

    public BetsControlPanel() {
        initGenerateTicketsButton();
        setLayout(new BorderLayout(5, 5));
        add(generateTicketsButton, BorderLayout.EAST);
    }

    private void initGenerateTicketsButton() {
        generateTicketsButton.setFocusPainted(false);
    }

}
