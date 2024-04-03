package app.league1x2.core;

import app.league1x2.gui.panels.betting.view.BetsTableModel;

public interface GenerateTickets {
    public BetTickets generateTickets(BetsTableModel betsTableModel, Integer stake);
}
