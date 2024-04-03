package app.league1x2.gui.panels.betting.control;

import javax.swing.*;
import java.awt.*;

public class BetsControlPanel extends JPanel {
    public final JButton deleteBetOddsButton = new JButton("Sterge");
    public final JButton generateTicketsButton = new JButton("Genereaza");

    public BetsControlPanel() {
        setLayout(new BorderLayout(5, 5));
        deleteBetOddsButton.setFocusPainted(false);
        generateTicketsButton.setFocusPainted(false);
        add(deleteBetOddsButton, BorderLayout.WEST);
        add(generateTicketsButton, BorderLayout.EAST);
    }

}
