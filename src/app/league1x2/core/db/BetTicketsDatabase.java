package app.league1x2.core.db;

import app.league1x2.core.BetTicket;
import app.league1x2.core.BetTickets;

public class BetTicketsDatabase {
    private static BetTickets betTickets = new BetTickets();
    private static int cursor;

    public static void setBetTickets(BetTickets betTickets) {
        BetTicketsDatabase.betTickets = betTickets;
        cursor = 0;
    }

    public static int size() {
        return betTickets.size();
    }

    public static void setCursor(int cursor) {
        BetTicketsDatabase.cursor = cursor;
        backwardCursor();
    }

    public static BetTicket get() {
        return betTickets.get(cursor);
    }

    public static int getCursor() {
        return cursor + 1;
    }

    public static void forwardCursor() {
        cursor = getCursor() % betTickets.size();
    }

    public static void backwardCursor() {
        if (cursor == 0) {
            cursor = size();
            backwardCursor();
        }
        else {
            cursor--;
        }
    }

}
