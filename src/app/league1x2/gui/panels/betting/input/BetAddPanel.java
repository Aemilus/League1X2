package app.league1x2.gui.panels.betting.input;

import javax.swing.*;
import java.awt.*;

public class BetAddPanel extends JPanel {
    public JButton addBetButton = new JButton("Adauga cotele");

    public BetAddPanel() {
        initAddBetButton();
        setLayout(new BorderLayout(5, 5));
        add(addBetButton, BorderLayout.CENTER);
    }

    private void initAddBetButton() {
        addBetButton.setFocusPainted(false);
//        addBetButton.setContentAreaFilled(false);
    }
}
