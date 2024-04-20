package app.league1x2.core;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.betting.Bet;
import app.league1x2.core.betting.BetOdds;
import app.league1x2.core.db.AllBetTicketsDatabase;
import app.league1x2.core.db.BetTicketsDatabase;
import app.league1x2.core.db.FilteredBetTicketsDatabase;
import app.league1x2.core.filter.FilterTotalOddsRange;
import app.league1x2.core.filter.SelectionRange;
import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTickets;
import app.league1x2.gui.panels.betting.table.BetsTableModel;
import app.league1x2.utils.CartesianProduct;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeagueCore {
    private final AllBetTicketsDatabase allBetTicketsDatabase = new AllBetTicketsDatabase();
    private final FilteredBetTicketsDatabase filteredBetTicketsDatabase = new FilteredBetTicketsDatabase();
    public BetTicketsDatabase activeBetTicketsDatabase = allBetTicketsDatabase;

    private List<List<Bet>> extractBetsFromModel(BetsTableModel betsTableModel) {
        List<List<Bet>> bets = new ArrayList<>();
        for (BetOdds betOdds : betsTableModel.data) {
            ArrayList<Bet> gameBets = new ArrayList<>();
            for (Map.Entry<String, Double> betOdd : betOdds.oddsMap.entrySet()) {
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
        clearFilterTickets();
        CartesianProduct<Bet> cp = new CartesianProduct<>();
        List<List<Bet>> cpBet = cp.getCartesianProduct(extractBetsFromModel(betsTableModel));
        int betTicketsCount = 0;
        BetTickets betTickets = new BetTickets();
        for (List<Bet> betList : cpBet) {
            betTicketsCount++;
            String betTicketName = MessageFormat.format("{0} {1}", LeagueAppConstants.TICKET, betTicketsCount);
            BetTicket betTicket = new BetTicket(betTicketName);
            for (Bet bet : betList) {
                betTicket.addBet(bet);
            }
            betTickets.add(betTicket);
        }

        return betTickets;
    }

    public ArrayList<BetTicket> getTicketsRange() {
        if (allBetTicketsDatabase.size() == 0) {
            return null;
        }
        ArrayList<BetTicket> range = new ArrayList<>();
        range.add(allBetTicketsDatabase.minTicket);
        range.add(allBetTicketsDatabase.maxTicket);
        return range;
    }

    public void filterTickets(FilterTotalOddsRange filterTotalOddsRange,
                              ArrayList<SelectionRange> filterSelectionsRange) {
        if (LeagueAppConstants.DEBUG) {
            System.out.println(filterTotalOddsRange);
            System.out.println(filterSelectionsRange);
        }

        BetTicketsDatabase tempDatabase = new FilteredBetTicketsDatabase();

        if (filterTotalOddsRange.isValid()) {
            for (BetTicket betTicket : allBetTicketsDatabase.betTickets) {
                if (betTicket.getOddsTotal() < filterTotalOddsRange.minTotalOdds) continue;
                if (betTicket.getOddsTotal() > filterTotalOddsRange.maxTotalOdds) continue;
                tempDatabase.add(betTicket);
            }
        } else {
            tempDatabase = allBetTicketsDatabase;
        }

        filteredBetTicketsDatabase.clear();
        activeBetTicketsDatabase = filteredBetTicketsDatabase;
        loop1:
        for (BetTicket betTicket : tempDatabase.getBetTickets()) {
            for (SelectionRange selectionRange : filterSelectionsRange) {
                if (!selectionRange.isInRange(betTicket)) continue loop1;
            }
            filteredBetTicketsDatabase.add(betTicket);
        }
    }

    public void clearFilterTickets() {
        filteredBetTicketsDatabase.betTickets.clear();
        activeBetTicketsDatabase = allBetTicketsDatabase;
    }

}
