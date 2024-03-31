
package app.league1x2.gui.panel.root;

import app.league1x2.core.BetOdds;
import app.league1x2.gui.panel.input.BetInputPanel;
import app.league1x2.gui.panel.view.BetsViewPanel;

import javax.swing.*;
import java.awt.*;

public class LeagueRootPanel extends JPanel {
    private final BetInputPanel betInputPanel = new BetInputPanel();
    private final BetsViewPanel betsViewPanel = new BetsViewPanel();

    public LeagueRootPanel() {
        setLayout(new BorderLayout(5, 5));
        add(betInputPanel, BorderLayout.NORTH);
        add(betsViewPanel, BorderLayout.CENTER);
    }

    public BetOdds getBetOdds() {
        return betInputPanel.getBetOdds();
    }

}
