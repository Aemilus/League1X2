package app.league1x2.gui.panel.input;

import app.league1x2.core.BetOdds;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BetInputPanel extends JPanel {
    private final BetNamePanel betNamePanel = new BetNamePanel();
    private final BetOddsPanel betOddsPanel = new BetOddsPanel();
    public final AddBetPanel addBetPanel = new AddBetPanel();

    public BetInputPanel() {
        setLayout(new BorderLayout(5, 5));
        add(betNamePanel, BorderLayout.WEST);
        add(betOddsPanel, BorderLayout.CENTER);
        add(addBetPanel, BorderLayout.EAST);
    }

    public BetOdds getBetOdds() {
        String betName = betNamePanel.getBetName();
        ArrayList<Double> betOddsList = betOddsPanel.getBetOdds();
        return new BetOdds(betName, betOddsList.get(0), betOddsList.get(1), betOddsList.get(2));
    }

}
