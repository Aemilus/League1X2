package app.league1x2.core;

import java.util.LinkedHashMap;

public class BetOdds {
    public String name;
    public final LinkedHashMap<String, Double> oddsMap;

    public BetOdds(String name, LinkedHashMap<String, Double> oddsMap) {
        this.name = name;
        this.oddsMap = oddsMap;
    }

}
