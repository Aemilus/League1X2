package app.league1x2.gui.panel.input;

import app.league1x2.core.BetOdds;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BetInputPanel extends JPanel {
    private final BetNamePanel betNamePanel = new BetNamePanel();
    private final BetOddsPanel betOddsPanel = new BetOddsPanel();
    private final BetAddPanel betAddPanel = new BetAddPanel();

    public BetInputPanel() {
//        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//        add(betNamePanel);
//        add(betOddsPanel);
//        add(betAddPanel);
        setLayout(new BorderLayout(5, 5));
        add(betNamePanel, BorderLayout.WEST);
        add(betOddsPanel, BorderLayout.CENTER);
        add(betAddPanel, BorderLayout.EAST);
    }

    public BetOdds getBetOdds() {
        String betName = betNamePanel.getBetName();
        ArrayList<Double> betOddsList = betOddsPanel.getBetOdds();
        return new BetOdds(betName, betOddsList.get(0), betOddsList.get(1), betOddsList.get(2));
    }

}
