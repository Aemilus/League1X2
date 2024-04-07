package app.league1x2.core.db;

import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTickets;

public class BaseBetTicketsDatabase implements BetTicketsDatabase {
    public BetTickets betTickets = new BetTickets();
    private int cursor;

    @Override
    public void clear() {
        betTickets.clear();
        cursor = 0;
    }

    @Override
    public void setBetTickets(BetTickets betTickets) {
        this.betTickets = betTickets;
        cursor = 0;
    }

    @Override
    public int size() {
        return betTickets.size();
    }

    @Override
    public void setCursor(int cursor) {
        this.cursor = cursor;
        backwardCursor();
    }

    @Override
    public BetTicket get() {
        if (size() == 0) {
            return null;
        }
        return betTickets.get(cursor);
    }

    @Override
    public int getCursor() {
        if (size() == 0) return 0;
        return cursor + 1;
    }

    @Override
    public void forwardCursor() {
        cursor = getCursor() % betTickets.size();
    }

    @Override
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
