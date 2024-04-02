package app.league1x2.core;

import app.league1x2.core.db.BetTicketsDatabase;
import app.league1x2.gui.panel.view.BetsTableModel;
import app.league1x2.utils.CartesianProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeagueCore implements GenerateTickets {
    private final BetTicketsDatabase betTicketsDatabase = new BetTicketsDatabase();

    public BetTicketsDatabase getBetTicketsDatabase() {
        return betTicketsDatabase;
    }

    private List<List<Bet>> extractBetsFromModel(BetsTableModel betsTableModel) {
        List<List<Bet>> bets = new ArrayList<>();
        for (BetOdds betOdds : betsTableModel.data) {
            ArrayList<Bet> gameBets = new ArrayList<>();
            for (Map.Entry<String, Double> betOdd : betOdds.getOddsMap().entrySet()) {
                Bet bet = new Bet(betOdds.getName(), betOdd.getKey(), betOdd.getValue());
                gameBets.add(bet);
            }
            bets.add(gameBets);
        }
        return bets;
    }

    @Override
    public BetTickets generateTickets(BetsTableModel betsTableModel, Integer stake) {
        CartesianProduct<Bet> cp = new CartesianProduct<>();
        List<List<Bet>> cpBet = cp.getCartesianProduct(extractBetsFromModel(betsTableModel));
        int betTicketsCount = 0;
        BetTickets betTickets = new BetTickets();
        for (List<Bet> betList : cpBet) {
            betTicketsCount++;
            BetTicket betTicket = new BetTicket(STR."Bilet \{betTicketsCount}");
            for (Bet bet : betList) {
                betTicket.addBet(bet);
            }
            betTickets.add(betTicket);
        }

        return betTickets;
    }

}
