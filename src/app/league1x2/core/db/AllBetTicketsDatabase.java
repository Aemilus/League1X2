package app.league1x2.core.db;

import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTickets;

public class AllBetTicketsDatabase extends BaseBetTicketsDatabase {
    public BetTicket minTicket;
    public BetTicket maxTicket;

    public void setBetTickets(BetTickets betTickets) {
        super.setBetTickets(betTickets);
        findMinMaxTicket();
    }

    private void findMinMaxTicket() {
        if (betTickets.isEmpty()) return;

        minTicket = betTickets.getFirst();
        maxTicket = betTickets.getFirst();

        BetTicket currentTicket;
        for(int i=1; i<size(); i++) {
            currentTicket = betTickets.get(i);
            if (currentTicket.getOddsTotal() < minTicket.getOddsTotal()) minTicket = currentTicket;
            if (currentTicket.getOddsTotal() > maxTicket.getOddsTotal()) maxTicket = currentTicket;
        }
    }

}
