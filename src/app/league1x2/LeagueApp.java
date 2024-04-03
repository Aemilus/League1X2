
package app.league1x2;

import app.league1x2.core.betting.BetOdds;
import app.league1x2.core.tickets.BetTickets;
import app.league1x2.core.LeagueCore;
import app.league1x2.gui.LeagueGUI;

@SuppressWarnings("unused")
public final class LeagueApp {
    private final LeagueCore core = new LeagueCore();
    private final LeagueGUI gui = new LeagueGUI();

    private LeagueApp() {
        configAddBetButton();
        configDeleteBetOddsButton();
        configGenerateTicketsButton();
        configForwardButton();
        configBackwardButton();
        configFilterTicketsButton();
    }

    private void configAddBetButton() {
        gui.getBetInputPanel().addBetPanel.addBetButton.addActionListener(event -> {
            BetOdds betOdds = gui.getBetInputPanel().getBetOdds();
            gui.getBetInputPanel().betNamePanel.setNextBetName();
            gui.getBetsTablePanel().betsTableModel.addRow(betOdds);
            gui.getBetsTablePanel().betsTableModel.fireTableDataChanged();
        });
    }

    private void configDeleteBetOddsButton() {
        gui.getBetsControlPanel().deleteBetOddsButton.addActionListener(event -> {
            int[] rowsIndex = gui.getBetsTablePanel().betsTable.getSelectedRows();
            for(int i=rowsIndex.length - 1; i>=0; i--) {
                int rowIndex = rowsIndex[i];
                gui.getBetsTablePanel().betsTableModel.removeRow(rowIndex);
            }
            gui.getBetsTablePanel().betsTableModel.fireTableDataChanged();
        });
    }

    private void configGenerateTicketsButton() {
        gui.getBetsControlPanel().generateTicketsButton.addActionListener(event -> {
            if (gui.getBetsTablePanel().betsTableModel.data.isEmpty()) {
                return;
            }
            BetTickets tickets = core.generateTickets(gui.getBetsTablePanel().betsTableModel);
//            tickets.print();
            core.betTicketsDatabase.setBetTickets(tickets);
            refreshDisplayTicketsPanel();
        });
    }

    private void refreshDisplayTicketsPanel() {
        if (core.betTicketsDatabase.size() > 0) {
            core.betTicketsDatabase.setCursor(1);
            gui.getTicketTablePanel().ticketTableModel.setData(core.betTicketsDatabase.get());
            gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
            updateCurrentTicketTextFields();
            updateFilterTicketsInputPanel();
        }
    }

    private void configForwardButton() {
        gui.getTicketsNavigationPanel().forwardButton.addActionListener(event -> {
            if (core.betTicketsDatabase.size() > 0) {
                core.betTicketsDatabase.forwardCursor();
                gui.getTicketTablePanel().ticketTableModel.setData(core.betTicketsDatabase.get());
                gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
                updateCurrentTicketTextFields();
            }
        });
    }

    private void configBackwardButton() {
        gui.getTicketsNavigationPanel().backwardButton.addActionListener(event -> {
            if (core.betTicketsDatabase.size() > 0) {
                core.betTicketsDatabase.backwardCursor();
                gui.getTicketTablePanel().ticketTableModel.setData(core.betTicketsDatabase.get());
                gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
                updateCurrentTicketTextFields();
            }
        });
    }

    private void configFilterTicketsButton() {

    }

    private void updateCurrentTicketTextFields() {
        String msg = STR."\{core.betTicketsDatabase.getCursor()} / \{core.betTicketsDatabase.size()}";
        gui.getTicketsNavigationPanel().
                currentTicketTextField.setText(msg);
        gui.getTicketsNavigationPanel().
                currentTicketTotalOddsTextField.setText(core.betTicketsDatabase.get().getOddsTotalAsString());
    }

    private void updateFilterTicketsInputPanel() {
        gui.getFilterTicketsInputPanel().
                minTicketOddsTotal.setText(core.betTicketsDatabase.minTicket.getOddsTotalAsString());
        gui.getFilterTicketsInputPanel().
                maxTicketOddsTotal.setText(core.betTicketsDatabase.maxTicket.getOddsTotalAsString());
    }

    private void start() {
        gui.draw();
    }

    public static void main(String[] args) {
        LeagueApp app = new LeagueApp();
        app.start();
    }
}
