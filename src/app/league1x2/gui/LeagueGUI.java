
package app.league1x2.gui;

import app.league1x2.gui.frame.LeagueFrame;
import app.league1x2.gui.panels.betting.control.BetsControlPanel;
import app.league1x2.gui.panels.betting.input.BetInputPanel;
import app.league1x2.gui.panels.betting.view.BetsTablePanel;
import app.league1x2.gui.panels.tickets.filter.FilterTicketsInputPanel;
import app.league1x2.gui.panels.tickets.navigate.TicketsNavigationPanel;
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
        return frame.framePanel.bettingRootPanel.betsViewPanel.betsTablePanel;
    }

    public BetsControlPanel getBetsControlPanel() {
        return frame.framePanel.bettingRootPanel.betsControlPanel;
    }

    public TicketsNavigationPanel getTicketsNavigationPanel() {
        return frame.framePanel.ticketsRootPanel.ticketsNavigationPanel;
    }

    public TicketTablePanel getTicketTablePanel() {
        return frame.framePanel.ticketsRootPanel.ticketTablePanel;
    }

    public FilterTicketsInputPanel getFilterTicketsInputPanel() {
        return frame.framePanel.ticketsRootPanel.filterTicketsPanel.filterTicketsInputPanel;
    }

    //endregion

}
