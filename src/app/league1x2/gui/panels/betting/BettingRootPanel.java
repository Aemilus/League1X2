
package app.league1x2.gui.panels.betting;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.gui.panels.betting.control.BetsControlPanel;
import app.league1x2.gui.panels.betting.input.BetInputPanel;
import app.league1x2.gui.panels.betting.table.BetsTablePanel;

import javax.swing.*;
import java.awt.*;

public class BettingRootPanel extends JPanel {
    public final BetInputPanel betInputPanel = new BetInputPanel();
    public final BetsTablePanel betsTablePanel = new BetsTablePanel();
    public final BetsControlPanel betsControlPanel = new BetsControlPanel();

    public BettingRootPanel() {
        setPreferredSize(new Dimension(LeagueAppConstants.WIDTH / 3, 0));
        setLayout(new BorderLayout(5, 5));
        add(betInputPanel, BorderLayout.NORTH);
        add(betsTablePanel, BorderLayout.CENTER);
        add(betsControlPanel, BorderLayout.SOUTH);
    }

}
