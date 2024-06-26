package app.league1x2.core.betting;

import app.league1x2.constants.LeagueAppConstants;

import java.text.MessageFormat;
import java.util.LinkedHashMap;

public class BetOdds {
    public String gameId;
    public String name;
    public final LinkedHashMap<String, Double> oddsMap;

    public BetOdds(String name, LinkedHashMap<String, Double> oddsMap) {
        this.name = name;
        this.oddsMap = oddsMap;
    }

    public boolean isValid() {
        int count = 0;
        for (Double value : oddsMap.values()) {
            if (value > LeagueAppConstants.VALID_ODDS) count++;
        }
        return count != 0;
    }

    public void setGameId(int gameId) {
        this.gameId = MessageFormat.format("{0}.", gameId);
    }

}
