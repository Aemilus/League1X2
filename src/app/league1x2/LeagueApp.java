
package app.league1x2;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.betting.BetOdds;
import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTickets;
import app.league1x2.core.LeagueCore;
import app.league1x2.gui.LeagueGUI;

import java.text.MessageFormat;
import java.util.ArrayList;

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
        configApplyFilterTicketsButton();
        configResetFilterTicketsButton();
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
            if (LeagueAppConstants.DEBUG) {
                tickets.print();
            }
            core.activeBetTicketsDatabase.setBetTickets(tickets);
            refreshDisplayTicketsPanel();
        });
    }

    private void refreshDisplayTicketsPanel() {
        if (core.activeBetTicketsDatabase.size() > 0) {
            core.activeBetTicketsDatabase.setCursor(1);
            gui.getTicketTablePanel().ticketTableModel.setData(core.activeBetTicketsDatabase.get());
            gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
            updateCurrentTicketTextFields();
            updateFilterTicketsInputPanel();
        }
    }

    private void configForwardButton() {
        gui.getTicketsNavigationPanel().forwardButton.addActionListener(event -> {
            if (core.activeBetTicketsDatabase.size() > 0) {
                core.activeBetTicketsDatabase.forwardCursor();
                gui.getTicketTablePanel().ticketTableModel.setData(core.activeBetTicketsDatabase.get());
                gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
                updateCurrentTicketTextFields();
            }
        });
    }

    private void configBackwardButton() {
        gui.getTicketsNavigationPanel().backwardButton.addActionListener(event -> {
            if (core.activeBetTicketsDatabase.size() > 0) {
                core.activeBetTicketsDatabase.backwardCursor();
                gui.getTicketTablePanel().ticketTableModel.setData(core.activeBetTicketsDatabase.get());
                gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
                updateCurrentTicketTextFields();
            }
        });
    }

    private void configApplyFilterTicketsButton() {
        gui.getFilterTicketsControlPanel().applyFilterTicketsButton.addActionListener(event -> {
            String minText = gui.getFilterTicketsInputPanel().minTicketOddsTotal.getText().trim();
            String maxText = gui.getFilterTicketsInputPanel().maxTicketOddsTotal.getText().trim();
            if (minText.isEmpty()) return;
            if (maxText.isEmpty()) return;

            double inputMin = Double.parseDouble(minText);
            double inputMax = Double.parseDouble(maxText);
            if (inputMin < LeagueAppConstants.VALID_ODDS) return;
            if (inputMax < LeagueAppConstants.VALID_ODDS) return;
            if (inputMax < inputMin) return;

            core.filterTickets(inputMin, inputMax);
            gui.getTicketTablePanel().ticketTableModel.setData(core.activeBetTicketsDatabase.get());
            gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
            updateCurrentTicketTextFields();
        });
    }

    private void configResetFilterTicketsButton() {

    }

    private void updateCurrentTicketTextFields() {
        String msg = MessageFormat.format("{0} / {1}",
                core.activeBetTicketsDatabase.getCursor(), core.activeBetTicketsDatabase.size());
        gui.getTicketsNavigationPanel().
                currentTicketTextField.setText(msg);
        if (core.activeBetTicketsDatabase.size() > 0) {
            String odds = core.activeBetTicketsDatabase.get().getOddsTotalAsString();
            gui.getTicketsNavigationPanel().
                    currentTicketTotalOddsTextField.setText(odds);
        }
    }

    private void updateFilterTicketsInputPanel() {
        String minText = "";
        String maxText = "";
        ArrayList<BetTicket> range = core.getTicketsRange();
        if (range != null) {
            minText = range.get(0).getOddsTotalAsString();
            maxText = range.get(1).getOddsTotalAsString();
        }
        gui.getFilterTicketsInputPanel().
                minTicketOddsTotal.setText(minText);
        gui.getFilterTicketsInputPanel().
                maxTicketOddsTotal.setText(maxText);
    }

    private void start() {
        gui.draw();
    }

    public static void main(String[] args) {
        LeagueApp app = new LeagueApp();
        app.start();
    }
}
