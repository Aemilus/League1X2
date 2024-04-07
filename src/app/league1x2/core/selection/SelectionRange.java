package app.league1x2.core.selection;

public class SelectionRange {
    public final String selection;
    public int min;
    public int max;

    public SelectionRange(String selection, String min, String max) {
        this.selection = selection;
        this.min = parseRangeValue(min);
        this.max = parseRangeValue(max);
    }

    private int parseRangeValue(String range) {
        int value;
        try {
            value = Integer.parseInt(range.trim());
        } catch (NumberFormatException e) {
            value = 0;
        }
        return value;
    }

    public boolean isValid() {
        if (min < 0) return false;
        if (max < 0) return false;
        return (max >= min);
    }

}
