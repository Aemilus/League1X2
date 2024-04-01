package app.league1x2.gui.panel.input;

import app.league1x2.core.BetOdds;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class BetInputPanel extends JPanel {
    public final BetNamePanel betNamePanel = new BetNamePanel();
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
        LinkedHashMap<String, Double> betOddsList = betOddsPanel.getBetOdds();
        return new BetOdds(
                betName,
                betOddsList.get(BetOddsPanel.selections[0]),
                betOddsList.get(BetOddsPanel.selections[1]),
                betOddsList.get(BetOddsPanel.selections[2])
        );
    }

}
