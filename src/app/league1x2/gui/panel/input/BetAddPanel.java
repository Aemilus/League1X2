package app.league1x2.gui.panel.input;

import javax.swing.*;
import java.awt.*;

public class BetAddPanel extends JPanel {
    private JButton addBetButton = new JButton("Adauga cote");

    public BetAddPanel() {
        addBetButton.setFocusPainted(false);
        addBetButton.setContentAreaFilled(false);
        setLayout(new BorderLayout(5, 5));
        add(addBetButton, BorderLayout.CENTER);
    }

}
