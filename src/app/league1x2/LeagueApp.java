
package app.league1x2;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.betting.BetOdds;
import app.league1x2.core.config.Config;
import app.league1x2.core.filter.FilterTotalOddsRange;
import app.league1x2.core.filter.SelectionRange;
import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTickets;
import app.league1x2.core.LeagueCore;
import app.league1x2.gui.LeagueGUI;
import app.league1x2.gui.panels.betting.table.BetsTableModel;
import app.league1x2.gui.style.Style;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

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
        configExportMenuItem();
        configImportMenuItem();
    }

    private void updateBetInputPanel() {
        gui.getBetsTablePanel().betsTableModel.fireTableDataChanged();
        int row_count = gui.getBetsTablePanel().betsTableModel.getRowCount();
        gui.getBetsControlPanel().gamesCountTextField.setText(String.valueOf(row_count));
        gui.getBetInputPanel().betOddsPanel.clear();
    }

    private void configAddBetButton() {
        gui.getBetInputPanel().betAddPanel.addBetButton.addActionListener(event -> {
            BetOdds betOdds = gui.getBetInputPanel().getBetOdds();
            if (betOdds.isValid()) {
                gui.getBetsTablePanel().betsTableModel.addRow(betOdds);
                gui.getBetInputPanel().betNamePanel.setNextBetName();
                updateBetInputPanel();
            }
        });
    }

    private void configDeleteBetOddsButton() {
        gui.getBetsControlPanel().deleteBetOddsButton.addActionListener(event -> {
            int[] rowsIndex = gui.getBetsTablePanel().betsTable.getSelectedRows();
            if (rowsIndex.length > 0) {
                for (int i = rowsIndex.length - 1; i >= 0; i--) {
                    int rowIndex = rowsIndex[i];
                    gui.getBetsTablePanel().betsTableModel.removeRow(rowIndex);
                }
                updateBetInputPanel();
                int row_count = gui.getBetsTablePanel().betsTableModel.getRowCount();
                if (row_count == 0) {
                    gui.getBetInputPanel().betNamePanel.clearGameIds();
                    gui.getBetInputPanel().betNamePanel.setNextBetName();
                }
            }
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
            updateTicketsStatsPanel();
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
        gui.getFiltersRootPanel().applyFiltersButton.addActionListener(event -> {
            FilterTotalOddsRange filterTotalOddsRange = gui.getFilterTicketsInputPanel().getTotalOddsRangeFilter();
            ArrayList<SelectionRange> filterSelectionRanges = gui.getFilterSelectionsPanel().getSelectionsRange();

            core.filterTickets(filterTotalOddsRange, filterSelectionRanges);
            gui.getTicketTablePanel().ticketTableModel.setData(core.activeBetTicketsDatabase.get());
            gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
            updateCurrentTicketTextFields();
        });
    }

    private void configResetFilterTicketsButton() {
        gui.getTicketsStatsPanel().resetFilterTicketsButton.addActionListener(event -> {
            core.clearFilterTickets();
            refreshDisplayTicketsPanel();
        });
    }

    private void updateCurrentTicketTextFields() {
        String msg = MessageFormat.format("{0} / {1}",
                core.activeBetTicketsDatabase.getCursor(), core.activeBetTicketsDatabase.size());
        gui.getTicketsNavigationPanel().
                currentTicketTextField.setText(msg);
        String odds;
        if (core.activeBetTicketsDatabase.size() > 0) {
            odds = core.activeBetTicketsDatabase.get().getOddsTotalAsString();
        } else {
            odds = null;
        }
        gui.getTicketsStatsPanel().
                currentTicketTotalOddsTextField.setText(odds);
    }

    private void updateTicketsStatsPanel() {
        String minText = null;
        String maxText = null;
        ArrayList<BetTicket> range = core.getTicketsRange();
        if (range != null) {
            minText = range.get(0).getOddsTotalAsString();
            maxText = range.get(1).getOddsTotalAsString();
        }
        gui.getTicketsStatsPanel().
                minTicketTotalOddsTextField.setText(minText);
        gui.getTicketsStatsPanel().
                maxTicketTotalOddsTextField.setText(maxText);
    }

    private void configExportMenuItem() {
        gui.getExportMenuItem().addActionListener(event -> {
            int selection = gui.getConfigFileChooser().showSaveDialog(gui.frame);
            if (selection == JFileChooser.APPROVE_OPTION) {
                BetsTableModel betsTableModel = gui.getBetsTablePanel().betsTableModel;
                File f = gui.getConfigFileChooser().getSelectedFile();
                Config.exportConfig(betsTableModel.data, f);
            }
        });
    }

    private void configImportMenuItem() {
        gui.getImportMenuItem().addActionListener(event -> {
            int selection = gui.getConfigFileChooser().showOpenDialog(gui.frame);
            if (selection == JFileChooser.APPROVE_OPTION) {
                System.out.println("Importing...");
                File f = gui.getConfigFileChooser().getSelectedFile();
                System.out.println(f.toString());
            }
        });
    }

    private void start() {
        gui.draw();
        gui.getBetInputPanel().betNamePanel.setNextBetName();
        updateBetInputPanel();
        updateCurrentTicketTextFields();
    }

    public static void main(String[] args) {
        Style.applyStyle();
        LeagueApp app = new LeagueApp();
        app.start();
    }
}
