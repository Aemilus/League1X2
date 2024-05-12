
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

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
        configUpButton();
        configDownButton();
        configGoToMinTicket();
        configGoToMaxTicket();
    }

    private void updateBetInputPanel() {
        gui.getBetsTablePanel().betsTableModel.fireTableDataChanged();
        gui.getBetInputPanel().clear();
    }

    private void configAddBetButton() {
        gui.getBetInputPanel().betAddPanel.addBetButton.addActionListener(event -> {
            BetOdds betOdds = gui.getBetInputPanel().getBetOdds();
            if (betOdds.isValid()) {
                betOdds.setGameId(gui.getBetsTablePanel().betsTableModel.getRowCount() + 1);
                gui.getBetsTablePanel().betsTableModel.addRow(betOdds);
                updateBetInputPanel();
            }
        });
    }

    private void configDeleteBetOddsButton() {
        gui.getBetsControlPanel().deleteBetOddsButton.addActionListener(event -> {
            int[] rowsIndex = gui.getBetsTablePanel().betsTable.getSelectedRows();
            if (rowsIndex.length > 0) {
                // remove rows
                for (int i = rowsIndex.length - 1; i >= 0; i--) {
                    int rowIndex = rowsIndex[i];
                    gui.getBetsTablePanel().betsTableModel.removeRow(rowIndex);
                }
                // renumber the game ids
                gui.getBetsTablePanel().betsTableModel.renumberGameIds();
                updateBetInputPanel();
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
            core.activeBetTicketsDatabase.findMinMaxTicket();
            updateTicketsStatsPanel();
        } else {
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
            refreshDisplayTicketsPanel();
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
                if (LeagueAppConstants.DEBUG) {System.out.println("Exporting...");}
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
                if (LeagueAppConstants.DEBUG) {System.out.println("Importing...");}
                File f = gui.getConfigFileChooser().getSelectedFile();
                ArrayList<BetOdds> betOddsList = Config.importConfig(f);
                if (LeagueAppConstants.DEBUG) {
                    betOddsList.forEach(bo -> System.out.println(bo.name));
                }
                gui.getBetsTablePanel().betsTableModel.data = betOddsList;
                updateBetInputPanel();
            }
        });
    }

    private void configUpButton() {
        gui.getBetsControlPanel().upButton.addActionListener(event -> {
            int[] rowsIndex = gui.getBetsTablePanel().betsTable.getSelectedRows();
            if (rowsIndex.length == 1) {
                int rowIndex1 = rowsIndex[0];
                int rowIndex2 = rowIndex1 - 1;
                if (rowIndex1 > 0) {
                    gui.getBetsTablePanel().betsTableModel.switchRows(rowIndex1, rowIndex2);
                    gui.getBetsTablePanel().betsTableModel.renumberGameIds();
                    updateBetInputPanel();
                    gui.getBetsTablePanel().betsTable.setRowSelectionInterval(rowIndex2, rowIndex2);
                }
            }
        });
    }

    private void configDownButton() {
        gui.getBetsControlPanel().downButton.addActionListener(event -> {
            int[] rowsIndex = gui.getBetsTablePanel().betsTable.getSelectedRows();
            if (rowsIndex.length == 1) {
                int rowIndex1 = rowsIndex[0];
                int rowIndex2 = rowIndex1 + 1;
                if (rowIndex2 < gui.getBetsTablePanel().betsTableModel.getRowCount()) {
                    gui.getBetsTablePanel().betsTableModel.switchRows(rowIndex1, rowIndex2);
                    gui.getBetsTablePanel().betsTableModel.renumberGameIds();
                    updateBetInputPanel();
                    gui.getBetsTablePanel().betsTable.setRowSelectionInterval(rowIndex2, rowIndex2);
                }
            }
        });
    }

    private void configGoToMinTicket() {
        gui.getTicketsStatsPanel().minTicketTotalOddsTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cursor = core.activeBetTicketsDatabase.getMinCursor();
                if (cursor > 0){
                    core.activeBetTicketsDatabase.setCursor(cursor);
                    gui.getTicketTablePanel().ticketTableModel.setData(core.activeBetTicketsDatabase.get());
                    gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
                    updateCurrentTicketTextFields();
                }
            }
        });
    }

    private void configGoToMaxTicket() {
        gui.getTicketsStatsPanel().maxTicketTotalOddsTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cursor = core.activeBetTicketsDatabase.getMaxCursor();
                if (cursor > 0){
                    core.activeBetTicketsDatabase.setCursor(cursor);
                    gui.getTicketTablePanel().ticketTableModel.setData(core.activeBetTicketsDatabase.get());
                    gui.getTicketTablePanel().ticketTableModel.fireTableDataChanged();
                    updateCurrentTicketTextFields();
                }
            }
        });
    }

    private void start() {
        gui.draw();
        updateBetInputPanel();
        updateCurrentTicketTextFields();
    }

    public static void main(String[] args) {
        Style.applyStyle();
        LeagueApp app = new LeagueApp();
        app.start();
    }
}
