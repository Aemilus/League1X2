package app.league1x2.gui.panel.input;

import javax.swing.*;
import java.awt.*;

public class AddBetPanel extends JPanel {
    public JButton addBetButton = new JButton("Adauga cote");

    public AddBetPanel() {
        initAddBetButton();
        setLayout(new BorderLayout(5, 5));
        add(addBetButton, BorderLayout.CENTER);
    }

    private void initAddBetButton() {
        addBetButton.setFocusPainted(false);
        addBetButton.setContentAreaFilled(false);
    }
}
