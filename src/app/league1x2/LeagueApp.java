
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
        configBackwardButton();
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
            if (gui.frame.rootPanelNew.betRootPanel.betsViewPanel.betsTablePanel.betsTableModel.data.isEmpty()) {
                return;
            }
            BetTickets tickets = core.generateTickets(
                    gui.frame.rootPanelNew.betRootPanel.betsViewPanel.betsTablePanel.betsTableModel, Integer.parseInt("10")
            );
            tickets.print();
            BetTicketsDatabase.setBetTickets(tickets);
            refreshDisplayTicketsPanel();
        });
    }

    private void refreshDisplayTicketsPanel() {
        if (BetTicketsDatabase.size() > 0) {
            BetTicketsDatabase.setCursor(1);
            gui.frame.rootPanelNew.ticketsRootPanel.displayTicketPanel.ticketTablePanel.ticketTableModel.setData(BetTicketsDatabase.get());
            gui.frame.rootPanelNew.ticketsRootPanel.displayTicketPanel.ticketTablePanel.ticketTableModel.fireTableDataChanged();
            updateCurrentTicketTextField();
        }
    }

    private void configForwardButton() {
        gui.frame.rootPanelNew.ticketsRootPanel.ticketsNavigationPanel.forwardButton.addActionListener(event -> {
            if (BetTicketsDatabase.size() > 0) {
                BetTicketsDatabase.forwardCursor();
                gui.frame.rootPanelNew.ticketsRootPanel.displayTicketPanel.ticketTablePanel.ticketTableModel.setData(BetTicketsDatabase.get());
                gui.frame.rootPanelNew.ticketsRootPanel.displayTicketPanel.ticketTablePanel.ticketTableModel.fireTableDataChanged();
                updateCurrentTicketTextField();
            }
        });
    }

    private void configBackwardButton() {
        gui.frame.rootPanelNew.ticketsRootPanel.ticketsNavigationPanel.backwardButton.addActionListener(event -> {
            if (BetTicketsDatabase.size() > 0) {
                BetTicketsDatabase.backwardCursor();
                gui.frame.rootPanelNew.ticketsRootPanel.displayTicketPanel.ticketTablePanel.ticketTableModel.setData(BetTicketsDatabase.get());
                gui.frame.rootPanelNew.ticketsRootPanel.displayTicketPanel.ticketTablePanel.ticketTableModel.fireTableDataChanged();
                updateCurrentTicketTextField();
            }
        });
    }

    private void updateCurrentTicketTextField() {
        String msg = STR."\{BetTicketsDatabase.getCursor()} / \{BetTicketsDatabase.size()}";
        gui.frame.rootPanelNew.ticketsRootPanel.ticketsNavigationPanel.currentTicketTextField.setText(msg);
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
