
package app.league1x2;

import app.league1x2.core.betting.BetOdds;
import app.league1x2.core.tickets.BetTickets;
import app.league1x2.core.LeagueCore;
import app.league1x2.gui.LeagueGUI;

@SuppressWarnings("unused")
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
        gui.frame.framePanel.bettingRootPanel.betInputPanel.addBetPanel.addBetButton.addActionListener(event -> {
            BetOdds betOdds = gui.frame.framePanel.bettingRootPanel.betInputPanel.getBetOdds();
            gui.frame.framePanel.bettingRootPanel.betInputPanel.betNamePanel.setNextBetName();
            gui.frame.framePanel.bettingRootPanel.betsViewPanel.betsTablePanel.betsTableModel.addRow(betOdds);
            gui.frame.framePanel.bettingRootPanel.betsViewPanel.betsTablePanel.betsTableModel.fireTableDataChanged();
        });
    }

    private void configGenerateTicketsButton() {
        gui.frame.framePanel.bettingRootPanel.betsControlPanel.generateTicketsButton.addActionListener(event -> {
            if (gui.frame.framePanel.bettingRootPanel.betsViewPanel.betsTablePanel.betsTableModel.data.isEmpty()) {
                return;
            }
            BetTickets tickets = core.generateTickets(gui.frame.framePanel.bettingRootPanel.betsViewPanel.betsTablePanel.betsTableModel);
            core.betTicketsDatabase.setBetTickets(tickets);
            refreshDisplayTicketsPanel();
        });
    }

    private void refreshDisplayTicketsPanel() {
        if (core.betTicketsDatabase.size() > 0) {
            core.betTicketsDatabase.setCursor(1);
            gui.frame.framePanel.ticketsRootPanel.ticketTablePanel.ticketTableModel.setData(core.betTicketsDatabase.get());
            gui.frame.framePanel.ticketsRootPanel.ticketTablePanel.ticketTableModel.fireTableDataChanged();
            updateCurrentTicketTextField();
            updateFilterTicketsInputPanel();
        }
    }

    private void configForwardButton() {
        gui.frame.framePanel.ticketsRootPanel.ticketsNavigationPanel.forwardButton.addActionListener(event -> {
            if (core.betTicketsDatabase.size() > 0) {
                core.betTicketsDatabase.forwardCursor();
                gui.frame.framePanel.ticketsRootPanel.ticketTablePanel.ticketTableModel.setData(core.betTicketsDatabase.get());
                gui.frame.framePanel.ticketsRootPanel.ticketTablePanel.ticketTableModel.fireTableDataChanged();
                updateCurrentTicketTextField();
            }
        });
    }

    private void configBackwardButton() {
        gui.frame.framePanel.ticketsRootPanel.ticketsNavigationPanel.backwardButton.addActionListener(event -> {
            if (core.betTicketsDatabase.size() > 0) {
                core.betTicketsDatabase.backwardCursor();
                gui.frame.framePanel.ticketsRootPanel.ticketTablePanel.ticketTableModel.setData(core.betTicketsDatabase.get());
                gui.frame.framePanel.ticketsRootPanel.ticketTablePanel.ticketTableModel.fireTableDataChanged();
                updateCurrentTicketTextField();
            }
        });
    }

    private void updateCurrentTicketTextField() {
        String msg = STR."\{core.betTicketsDatabase.getCursor()} / \{core.betTicketsDatabase.size()}";
        gui.frame.framePanel.ticketsRootPanel.ticketsNavigationPanel.currentTicketTextField.setText(msg);
    }

    private void updateFilterTicketsInputPanel() {
        gui.frame.framePanel.ticketsRootPanel.filterTicketsPanel.filterTicketsInputPanel.minTicketOddsTotal.setText(core.betTicketsDatabase.getMinTicket().getOddsTotalAsString());
        gui.frame.framePanel.ticketsRootPanel.filterTicketsPanel.filterTicketsInputPanel.maxTicketOddsTotal.setText(core.betTicketsDatabase.getMaxTicket().getOddsTotalAsString());
    }

    private void start() {
        gui.draw();
    }

    public static void main(String[] args) {
        LeagueApp app = new LeagueApp();
        app.start();
    }
}
