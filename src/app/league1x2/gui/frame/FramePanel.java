package app.league1x2.gui.frame;

import app.league1x2.gui.panels.betting.BettingRootPanel;
import app.league1x2.gui.panels.filters.FiltersRootPanel;
import app.league1x2.gui.panels.tickets.TicketsRootPanel;

import javax.swing.*;
import java.awt.*;

public class FramePanel extends JPanel {
    public final BettingRootPanel bettingRootPanel = new BettingRootPanel();
    public final TicketsRootPanel ticketsRootPanel = new TicketsRootPanel();
    public final FiltersRootPanel filtersRootPanel = new FiltersRootPanel();

    public FramePanel() {
        setLayout(new BorderLayout(20, 5));
        add(bettingRootPanel, BorderLayout.WEST);
        add(ticketsRootPanel, BorderLayout.CENTER);
        add(filtersRootPanel, BorderLayout.EAST);
    }
}
