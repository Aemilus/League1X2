package app.league1x2.core.db;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.tickets.BetTicket;
import app.league1x2.core.tickets.BetTickets;

import java.text.MessageFormat;

public class BaseBetTicketsDatabase implements BetTicketsDatabase {
    public BetTickets betTickets = new BetTickets();
    private int cursor;
    public BetTicket minTicket;
    public BetTicket maxTicket;

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
    public BetTicket getMinTicket() {
        return minTicket;
    }

    @Override
    public BetTicket getMaxTicket() {
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

    public void findMinMaxTicket() {
        if (betTickets.isEmpty()) return;

        minTicket = betTickets.get(0);
        maxTicket = betTickets.get(0);

        BetTicket currentTicket;
        for(int i=1; i<size(); i++) {
            currentTicket = betTickets.get(i);
            if (currentTicket.getOddsTotal() < minTicket.getOddsTotal()) minTicket = currentTicket;
            if (currentTicket.getOddsTotal() > maxTicket.getOddsTotal()) maxTicket = currentTicket;
        }

        if (LeagueAppConstants.DEBUG) {
            String min = MessageFormat.format("minTicket: {0}", minTicket);
            String max = MessageFormat.format("maxTicket: {0}", maxTicket);
            System.out.println(min);
            System.out.println(max);
        }
    }

}
