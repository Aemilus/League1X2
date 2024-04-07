package app.league1x2.core.db;

import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTickets;

public interface BetTicketsDatabase {

    void clear();

    void setBetTickets(BetTickets betTickets);

    int size();

    BetTicket get();

    int getCursor();

    void setCursor(int cursor);

    void forwardCursor();

    void backwardCursor();
}
