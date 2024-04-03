package app.league1x2.core.db;

import app.league1x2.core.BetTicket;
import app.league1x2.core.BetTickets;

public class BetTicketsDatabase {
    private BetTickets betTickets = new BetTickets();
    private int cursor;
    private BetTicket minTicket;
    private BetTicket maxTicket;

    public void setBetTickets(BetTickets betTickets) {
        this.betTickets = betTickets;
        findMinMaxTicket();
        cursor = 0;
    }

    private void findMinMaxTicket() {
        minTicket = betTickets.getFirst();
        maxTicket = betTickets.getFirst();

        BetTicket currentTicket;
        for(int i=1; i<size(); i++) {
            currentTicket = betTickets.get(i);
            if (currentTicket.getOddsTotal() < minTicket.getOddsTotal()) minTicket = currentTicket;
            if (currentTicket.getOddsTotal() > maxTicket.getOddsTotal()) maxTicket = currentTicket;
        }
    }

    public BetTicket getMinTicket() {
        return minTicket;
    }

    public BetTicket getMaxTicket() {
        return maxTicket;
    }

    public int size() {
        return betTickets.size();
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
        backwardCursor();
    }

    public BetTicket get() {
        return betTickets.get(cursor);
    }

    public int getCursor() {
        return cursor + 1;
    }

    public void forwardCursor() {
        cursor = getCursor() % betTickets.size();
    }

    public void backwardCursor() {
        if (cursor == 0) {
            cursor = size();
            backwardCursor();
        }
        else {
            cursor--;
        }
    }

}
