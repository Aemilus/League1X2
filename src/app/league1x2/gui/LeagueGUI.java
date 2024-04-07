
package app.league1x2.gui;

import app.league1x2.gui.frame.LeagueFrame;
import app.league1x2.gui.panels.betting.control.BetsControlPanel;
import app.league1x2.gui.panels.betting.input.BetInputPanel;
import app.league1x2.gui.panels.betting.table.BetsTablePanel;
import app.league1x2.gui.panels.filter.control.FilterTicketsControlPanel;
import app.league1x2.gui.panels.filter.range.FilterTicketsRangePanel;
import app.league1x2.gui.panels.tickets.navigate.TicketsNavigationPanel;
import app.league1x2.gui.panels.tickets.stats.TicketsStatsPanel;
import app.league1x2.gui.panels.tickets.table.TicketTablePanel;

import javax.swing.*;

public class LeagueGUI {
    private final LeagueFrame frame = new LeagueFrame();

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception exception) {
            printLookAndFeel();
        }
    }

    private void printLookAndFeel() {
        UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo laf : lafInfo) {
            System.out.println(laf);
        }
    }

    public void draw() {
        setLookAndFeel();
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    // region panels getters
    public BetInputPanel getBetInputPanel() {
        return frame.framePanel.bettingRootPanel.betInputPanel;
    }

    public BetsTablePanel getBetsTablePanel() {
        return frame.framePanel.bettingRootPanel.betsTablePanel;
    }

    public BetsControlPanel getBetsControlPanel() {
        return frame.framePanel.bettingRootPanel.betsControlPanel;
    }

    public TicketsStatsPanel getTicketsStatsPanel() {
        return frame.framePanel.ticketsRootPanel.ticketsStatsPanel;
    }

    public TicketTablePanel getTicketTablePanel() {
        return frame.framePanel.ticketsRootPanel.ticketTablePanel;
    }

    public TicketsNavigationPanel getTicketsNavigationPanel() {
        return frame.framePanel.ticketsRootPanel.ticketsNavigationPanel;
    }

    public FilterTicketsRangePanel getFilterTicketsInputPanel() {
        return frame.framePanel.filterRootPanel.filterTicketsRangePanel;
    }

    public FilterTicketsControlPanel getFilterTicketsControlPanel() {
        return frame.framePanel.filterRootPanel.filterTicketsControlPanel;
    }

    //endregion

}
