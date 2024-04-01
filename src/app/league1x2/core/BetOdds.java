package app.league1x2.core;

import java.util.ArrayList;

public class BetOdds implements ValidBet {
    private final String name;
    private final ArrayList<Double> odds = new ArrayList<>();

    public BetOdds(String name, Double odd1, Double oddX, Double odd2) {
        this.name = name;
        this.odds.add(odd1);
        this.odds.add(oddX);
        this.odds.add(odd2);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getOdds() {
        return odds;
    }

    @Override
    public boolean isValid() {
        return !this.name.isEmpty();
    }
}
