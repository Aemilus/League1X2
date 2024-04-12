package app.league1x2.core.filter;

import app.league1x2.constants.LeagueAppConstants;

import java.text.MessageFormat;

public class FilterTotalOddsRange {
    public Double minTotalOdds;
    public Double maxTotalOdds;

    public FilterTotalOddsRange(String minTotalOddsText, String maxTotalOddsText) {
        minTotalOdds = parseTotalOddsText(minTotalOddsText);
        maxTotalOdds = parseTotalOddsText(maxTotalOddsText);
    }

    public boolean isValid() {
        return (minTotalOdds != null) && (maxTotalOdds != null) && !(maxTotalOdds < minTotalOdds);
    }

    private Double parseTotalOddsText(String totalOddsText) {
        if (totalOddsText == null) return null;

        String oddsText = totalOddsText.trim();
        if (oddsText.isEmpty()) return null;

        double totalOdds;
        try {
            totalOdds = Double.parseDouble(oddsText);
        } catch (NumberFormatException e) {
            return null;
        }
        if (totalOdds < LeagueAppConstants.VALID_ODDS) return null;

        return totalOdds;
    }

    @Override
    public String toString() {
        return MessageFormat.format("FilterTotalOddsRange'{'minTotalOdds={0}, maxTotalOdds={1}'}'", minTotalOdds, maxTotalOdds);
    }
}
