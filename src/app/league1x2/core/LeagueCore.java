package app.league1x2.core;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.betting.Bet;
import app.league1x2.core.betting.BetOdds;
import app.league1x2.core.db.BetTicketsDatabase;
import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTickets;
import app.league1x2.gui.panels.betting.view.BetsTableModel;
import app.league1x2.utils.CartesianProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeagueCore {
    public final BetTicketsDatabase betTicketsDatabase = new BetTicketsDatabase();

    private List<List<Bet>> extractBetsFromModel(BetsTableModel betsTableModel) {
        List<List<Bet>> bets = new ArrayList<>();
        for (BetOdds betOdds : betsTableModel.data) {
            ArrayList<Bet> gameBets = new ArrayList<>();
            for (Map.Entry<String, Double> betOdd : betOdds.oddsMap.entrySet()) {
                System.out.println(betOdd);
                if (Double.compare(betOdd.getValue(), LeagueAppConstants.VALID_ODDS) > 0) {
                    Bet bet = new Bet(betOdds.name, betOdd.getKey(), betOdd.getValue());
                    gameBets.add(bet);
                }
            }
            bets.add(gameBets);
        }
        return bets;
    }

    public BetTickets generateTickets(BetsTableModel betsTableModel) {
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
