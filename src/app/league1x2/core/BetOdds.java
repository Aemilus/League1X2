package app.league1x2.core;

public class BetOdds {
    private final String name;
    private final Double odd1;
    private final Double oddX;
    private final Double odd2;

    public BetOdds(String name, Double odd1, Double oddX, Double odd2) {
        this.name = name;
        this.odd1 = odd1;
        this.oddX = oddX;
        this.odd2 = odd2;
    }

    public String getName() {
        return name;
    }

    public Double getOdd1() {
        return odd1;
    }

    public Double getOddX() {
        return oddX;
    }

    public Double getOdd2() {
        return odd2;
    }

}
