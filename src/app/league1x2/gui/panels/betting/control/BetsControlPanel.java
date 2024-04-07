package app.league1x2.gui.panels.betting.control;

import javax.swing.*;
import java.awt.*;

public class BetsControlPanel extends JPanel {
    public final JButton deleteBetOddsButton = new JButton("Sterge");
    public JTextField gamesCountTextField = new JTextField(null, 4);
    public final JButton generateTicketsButton = new JButton("Genereaza");

    public BetsControlPanel() {
        initGamesCountTextField();
        deleteBetOddsButton.setFocusPainted(false);
        generateTicketsButton.setFocusPainted(false);
        setLayout(new BorderLayout(5, 5));
        add(deleteBetOddsButton, BorderLayout.WEST);
        add(gamesCountTextField, BorderLayout.CENTER);
        add(generateTicketsButton, BorderLayout.EAST);
    }

    private void initGamesCountTextField() {
        gamesCountTextField.setMargin(new Insets(2, 4, 2, 4));
        gamesCountTextField.setHorizontalAlignment(SwingConstants.CENTER);
        gamesCountTextField.setEditable(false);
    }

}
