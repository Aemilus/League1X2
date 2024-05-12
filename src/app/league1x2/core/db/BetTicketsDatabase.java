package app.league1x2.core.db;

import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTickets;

public interface BetTicketsDatabase {

    void clear();

    void setBetTickets(BetTickets betTickets);

    BetTickets getBetTickets();

    int size();

    boolean add(BetTicket betTicket);

    BetTicket get();

    int getCursor();

    void setCursor(int cursor);

    void forwardCursor();

    void backwardCursor();

    BetTicket getMinTicket();

    BetTicket getMaxTicket();

    void findMinMaxTicket();

    int getMinCursor();

    int getMaxCursor();
}
