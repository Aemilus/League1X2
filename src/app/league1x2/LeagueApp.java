
package app.league1x2;

import app.league1x2.core.BetOdds;
import app.league1x2.core.BetTickets;
import app.league1x2.core.LeagueCore;
import app.league1x2.core.db.BetTicketsDatabase;
import app.league1x2.gui.LeagueGUI;

public class LeagueApp {
    private final LeagueCore core = new LeagueCore();
    private final LeagueGUI gui = new LeagueGUI();

    public LeagueApp() {
        configGUI();
    }

    private void configGUI() {
        configAddBetButton();
        configGenerateTicketsButton();
        configForwardButton();
    }

    private void configAddBetButton() {
        gui.frame.rootPanelNew.betRootPanel.betInputPanel.addBetPanel.addBetButton.addActionListener(event -> {
            BetOdds betOdds = gui.frame.rootPanelNew.betRootPanel.betInputPanel.getBetOdds();
            gui.frame.rootPanelNew.betRootPanel.betInputPanel.betNamePanel.setNextBetName();
            gui.frame.rootPanelNew.betRootPanel.betsViewPanel.betsTablePanel.betsTableModel.addRow(betOdds);
            gui.frame.rootPanelNew.betRootPanel.betsViewPanel.betsTablePanel.betsTableModel.fireTableDataChanged();
        });
    }

    private void configGenerateTicketsButton() {
        gui.frame.rootPanelNew.betRootPanel.betsControlPanel.generateTicketsButton.addActionListener(event -> {
            BetTickets tickets = core.generateTickets(
                    gui.frame.rootPanelNew.betRootPanel.betsViewPanel.betsTablePanel.betsTableModel, Integer.parseInt("10")
            );
            tickets.print();
            BetTicketsDatabase.setBetTickets(tickets);
        });
    }

    private void configForwardButton() {
        gui.frame.rootPanelNew.ticketsRootPanel.ticketsNavigationPanel.forwardButton.addActionListener(event -> {
            if (BetTicketsDatabase.size() > 0) {
                gui.frame.rootPanelNew.ticketsRootPanel.displayTicketPanel.ticketTablePanel.ticketTableModel.setData(BetTicketsDatabase.get());
                BetTicketsDatabase.forwardCursor();
                gui.frame.rootPanelNew.ticketsRootPanel.displayTicketPanel.ticketTablePanel.ticketTableModel.fireTableDataChanged();
            }
        });
    }

    private void start() {
        core.start();
        gui.draw();
    }

    public static void main(String[] args) {
        LeagueApp app = new LeagueApp();
        app.start();
    }
}
