package app.league1x2.core;

import app.league1x2.gui.panel.view.BetsTableModel;

public class LeagueCore implements GenerateTickets {

    public void start() {
        System.out.println("starting core..");
    }

    @Override
    public BetTickets generateTickets(BetsTableModel betsTableModel, Integer stake) {
        int betTicketsCount = 0;
        BetTickets betTickets = new BetTickets();
        for (BetOdds betOdds : betsTableModel.data) {
            for (Double betOdd : betOdds.getOdds()) {
                betTicketsCount++;
                BetTicket betTicket = new BetTicket(STR."Bilet \{betTicketsCount}", stake);
                Bet bet = new Bet(betOdds.getName(), betOdd);
                betTicket.addBet(bet);
                betTickets.add(betTicket);
            }
        }
        return betTickets;
    }
}
