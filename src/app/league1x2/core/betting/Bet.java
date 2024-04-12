package app.league1x2.core.betting;

import java.text.MessageFormat;

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
        return MessageFormat.format(
                "Bet'{'name=''{0}'', selection=''{1}'', odd={2}'}'",
                name, selection, odd);
    }
}
