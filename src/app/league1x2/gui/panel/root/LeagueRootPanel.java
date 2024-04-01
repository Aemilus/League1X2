
package app.league1x2.gui.panel.root;

import app.league1x2.gui.panel.control.BetsControlPanel;
import app.league1x2.gui.panel.input.BetInputPanel;
import app.league1x2.gui.panel.view.BetsViewPanel;

import javax.swing.*;
import java.awt.*;

public class LeagueRootPanel extends JPanel {
    public final BetInputPanel betInputPanel = new BetInputPanel();
    public final BetsViewPanel betsViewPanel = new BetsViewPanel();
    public final BetsControlPanel betsControlPanel = new BetsControlPanel();

    public LeagueRootPanel() {
        setLayout(new BorderLayout(5, 5));
        add(betInputPanel, BorderLayout.NORTH);
        add(betsViewPanel, BorderLayout.CENTER);
        add(betsControlPanel, BorderLayout.SOUTH);
    }

}
