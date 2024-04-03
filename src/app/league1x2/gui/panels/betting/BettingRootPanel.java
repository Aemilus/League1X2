
package app.league1x2.gui.panels.betting;

import app.league1x2.gui.panels.betting.control.BetsControlPanel;
import app.league1x2.gui.panels.betting.input.BetInputPanel;
import app.league1x2.gui.panels.betting.view.BetsViewPanel;

import javax.swing.*;
import java.awt.*;

public class BettingRootPanel extends JPanel {
    public final BetInputPanel betInputPanel = new BetInputPanel();
    public final BetsViewPanel betsViewPanel = new BetsViewPanel();
    public final BetsControlPanel betsControlPanel = new BetsControlPanel();

    public BettingRootPanel() {
        setLayout(new BorderLayout(5, 5));
        add(betInputPanel, BorderLayout.NORTH);
        add(betsViewPanel, BorderLayout.CENTER);
        add(betsControlPanel, BorderLayout.SOUTH);
    }

}
