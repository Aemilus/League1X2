package app.league1x2.core;

import java.util.LinkedHashMap;

public class BetOdds implements ValidBet {
    private final String name;
    private final LinkedHashMap<String, Double> oddsMap = new LinkedHashMap<>();

    public BetOdds(String name, Double odd1, Double oddX, Double odd2) {
        this.name = name;
        this.oddsMap.put("1", odd1);
        this.oddsMap.put("X", oddX);
        this.oddsMap.put("2", odd2);
    }

    public String getName() {
        return name;
    }

    public LinkedHashMap<String, Double> getOddsMap() {
        return oddsMap;
    }

    @Override
    public boolean isValid() {
        return !this.name.isEmpty();
    }
}
