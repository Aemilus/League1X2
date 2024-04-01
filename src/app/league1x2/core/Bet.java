package app.league1x2.core;

public class Bet {
    private final String name;
    private final Double odd;

    public Bet(String name, Double odd) {
        this.name = name;
        this.odd = odd;
    }

    public String getName() {
        return name;
    }

    public Double getOdd() {
        return odd;
    }

    @Override
    public String toString() {
        return STR."Bet{name='\{name}\{'\''}, odd=\{odd}\{'}'}";
    }
}
