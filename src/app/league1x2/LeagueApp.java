
package app.league1x2;

import app.league1x2.core.BetOdds;
import app.league1x2.core.BetTickets;
import app.league1x2.core.LeagueCore;
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
    }

    private void configAddBetButton() {
        gui.frame.rootPanel.betInputPanel.addBetPanel.addBetButton.addActionListener(event -> {
            BetOdds betOdds = gui.frame.rootPanel.betInputPanel.getBetOdds();
            gui.frame.rootPanel.betsViewPanel.betsTablePanel.betsTableModel.addRow(betOdds);
            gui.frame.rootPanel.betsViewPanel.betsTablePanel.betsTableModel.fireTableDataChanged();
        });
    }

    private void configGenerateTicketsButton() {
        gui.frame.rootPanel.betsControlPanel.generateTicketsButton.addActionListener(event -> {
            BetTickets tickets = core.generateTickets(
                    gui.frame.rootPanel.betsViewPanel.betsTablePanel.betsTableModel, Integer.parseInt("10")
            );
            tickets.print();
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
