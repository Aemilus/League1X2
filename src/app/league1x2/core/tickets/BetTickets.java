package app.league1x2.core.tickets;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class BetTickets extends ArrayList<BetTicket> {
    public void print() {
        for (BetTicket betTicket : this) {
            System.out.println(betTicket);
        }
    }
}
