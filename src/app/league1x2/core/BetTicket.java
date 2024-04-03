package app.league1x2.core;

import java.util.ArrayList;

public class BetTicket {
    private final String name;
    private final ArrayList<Bet> bets = new ArrayList<>();
    private Double oddsTotal = Double.parseDouble("1.00");

    public BetTicket(String name) {
        this.name = name;
    }

    public ArrayList<Bet> getBets() {
        return bets;
    }

    public Double getOddsTotal() {
        return oddsTotal;
    }

    public String getOddsTotalAsString() {
        return String.format("%.2f", getOddsTotal());
    }

    public void addBet(Bet bet) {
        this.oddsTotal = this.oddsTotal * bet.getOdd();
        bets.add(bet);
    }

    @Override
    public String toString() {
        return STR."BetTicket{name='\{name}\{'\''}, bets=\{bets}, oddsTotal=\{oddsTotal}\{'}'}";
    }
}
