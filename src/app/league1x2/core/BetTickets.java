package app.league1x2.core;

import java.util.ArrayList;

public class BetTickets extends ArrayList<BetTicket> {
    public void print() {
        for (BetTicket betTicket : this) {
            System.out.println(betTicket);
        }
    }
}
