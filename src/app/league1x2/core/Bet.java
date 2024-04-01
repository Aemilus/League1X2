package app.league1x2.core;

public class Bet {
    private final String name;
    private final String selection;
    private final Double odd;

    public Bet(String name, String selection, Double odd) {
        this.name = name;
        this.selection = selection;
        this.odd = odd;
    }

    public String getName() {
        return name;
    }

    public String getSelection() {
        return selection;
    }

    public Double getOdd() {
        return odd;
    }

    @Override
    public String toString() {
        return STR."Bet{name='\{name}\{'\''}, selection='\{selection}\{'\''}, odd=\{odd}\{'}'}";
    }
}
