package app.league1x2.core;

import java.util.ArrayList;

public class BetTicket {
    private final String name;
    private final ArrayList<Bet> bets = new ArrayList<>();
    private final Integer stake;
    private Double gain = Double.parseDouble("1.00");

    public BetTicket(String name, Integer stake) {
        this.name = name;
        this.stake = stake;
        this.gain = this.gain * this.stake;
    }

    public ArrayList<Bet> getBets() {
        return bets;
    }

    public void addBet(Bet bet) {
        this.gain = this.gain * bet.getOdd();
        bets.add(bet);
    }

    @Override
    public String toString() {
        return STR."BetTicket{name='\{name}\{'\''}, bets=\{bets}, stake=\{stake}, gain=\{gain}\{'}'}";
    }
}
