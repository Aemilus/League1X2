package app.league1x2.core.filter;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.tickets.BetTicket;

import java.text.MessageFormat;

public class SelectionRange {
    public final String selection;
    public Integer min;
    public Integer max;

    public SelectionRange(String selection, String min, String max) {
        this.selection = selection;
        this.min = parseRangeValue(min);
        this.max = parseRangeValue(max);
    }

    private Integer parseRangeValue(String range) {
        if (range == null) return null;
        int value;
        try {
            value = Integer.parseInt(range.trim());
        } catch (NumberFormatException e) {
            return null;
        }
        return value;
    }

    public boolean isValid() {
        boolean status =
                (min != null) && (max != null) &&
                !(min < 0) && !(max < 0) && !(max < min);
        if (LeagueAppConstants.DEBUG) {
            System.out.println(
                    MessageFormat.format("isValid={0} for {1}", status, this));
        }
        return status;
    }

    public boolean isInRange(BetTicket betTicket) {
        boolean status =
                !(betTicket.getSelectionCount(selection) < min) &&
                !(betTicket.getSelectionCount(selection) > max);
        if (LeagueAppConstants.DEBUG) {
            System.out.println(
                    MessageFormat.format("betTicket {0} isInRange={1} for {2}",
                            betTicket, status, this));
        }
        return status;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "SelectionRange'{'selection=''{0}'', min={1}, max={2}'}'", selection, min, max);
    }
}
