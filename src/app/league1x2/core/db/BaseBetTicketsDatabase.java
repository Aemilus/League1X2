package app.league1x2.core.db;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTicketPosition;
import app.league1x2.core.tickets.BetTickets;

import java.text.MessageFormat;

public class BaseBetTicketsDatabase implements BetTicketsDatabase {
    private BetTickets betTickets = new BetTickets();
    private int cursor;
    private final BetTicketPosition minTicket = new BetTicketPosition();
    private final BetTicketPosition maxTicket = new BetTicketPosition();

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
    public BetTicketPosition getMinTicket() {
        return minTicket;
    }

    @Override
    public BetTicketPosition getMaxTicket() {
        return maxTicket;
    }

    @Override
    public BetTickets getBetTickets() {
        return betTickets;
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
    public boolean add(BetTicket betTicket) {
        return betTickets.add(betTicket);
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

    public void findAndSetMinMaxTicket() {
        if (betTickets.isEmpty()) {
            minTicket.clear();
            maxTicket.clear();
            return;
        }

        minTicket.betTicket = betTickets.get(0);
        maxTicket.betTicket = betTickets.get(0);
        minTicket.cursor = 1;
        maxTicket.cursor = 1;

        BetTicket currentTicket;
        for(int i=1; i<size(); i++) {
            currentTicket = betTickets.get(i);
            if (currentTicket.getOddsTotal() < minTicket.betTicket.getOddsTotal()) {
                minTicket.betTicket = currentTicket;
                minTicket.cursor = i+1;
            }
            if (currentTicket.getOddsTotal() > maxTicket.betTicket.getOddsTotal()) {
                maxTicket.betTicket= currentTicket;
                maxTicket.cursor = i+1;
            }
        }

        if (LeagueAppConstants.DEBUG) {
            String min = MessageFormat.format("cursor: {0}\tminTicket: {1}", minTicket.cursor, minTicket);
            String max = MessageFormat.format("cursor: {0}\tmaxTicket: {1}", maxTicket.cursor, maxTicket);
            System.out.println(min);
            System.out.println(max);
        }
    }

}
