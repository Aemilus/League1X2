package app.league1x2.gui.panel.root;

import javax.swing.*;
import java.awt.*;

public class LeagueRootPanel extends JPanel {
    public BetRootPanel betRootPanel = new BetRootPanel();
    public final TicketsRootPanel ticketsRootPanel = new TicketsRootPanel();

    public LeagueRootPanel() {
        setLayout(new BorderLayout(20, 5));
        add(betRootPanel, BorderLayout.CENTER);
        add(ticketsRootPanel, BorderLayout.EAST);
    }
}
