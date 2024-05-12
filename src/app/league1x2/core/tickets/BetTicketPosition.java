package app.league1x2.core.tickets;

public class BetTicketPosition {
    public int cursor;
    public BetTicket betTicket;

    public BetTicketPosition() {
        clear();
    }

    public void clear() {
        cursor = -1;
        betTicket = null;
    }

}
