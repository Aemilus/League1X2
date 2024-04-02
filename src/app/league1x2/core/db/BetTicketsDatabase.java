package app.league1x2.core.db;

import app.league1x2.core.BetTicket;
import app.league1x2.core.BetTickets;

public class BetTicketsDatabase {
    private BetTickets betTickets = new BetTickets();
    private int cursor;

    public void setBetTickets(BetTickets betTickets) {
        this.betTickets = betTickets;
        cursor = 0;
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
