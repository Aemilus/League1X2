package app.league1x2.gui.panels.betting.control;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;
import java.awt.*;

public class BetsControlPanel extends JPanel {
    public final JButton upButton = new JButton(LeagueAppConstants.UP_ARROW);
    public final JButton downButton = new JButton(LeagueAppConstants.DOWN_ARROW);
    public final JButton deleteBetOddsButton = new JButton("Sterge");
    public final JButton generateTicketsButton = new JButton("Genereaza");

    public BetsControlPanel() {
        deleteBetOddsButton.setFocusPainted(false);
        generateTicketsButton.setFocusPainted(false);
        JPanel moveButtonsPanel = new JPanel();
        initMoveButtons(moveButtonsPanel);

        setLayout(new BorderLayout(25, 5));
        add(moveButtonsPanel, BorderLayout.WEST);
        add(generateTicketsButton, BorderLayout.CENTER);
        add(deleteBetOddsButton, BorderLayout.EAST);
    }

    private void initMoveButtons(JPanel p) {
        upButton.setFocusPainted(false);
        downButton.setFocusPainted(false);
        p.setLayout(new BorderLayout(5, 5));
        p.add(downButton, BorderLayout.WEST);
        p.add(upButton, BorderLayout.EAST);
    }

}
