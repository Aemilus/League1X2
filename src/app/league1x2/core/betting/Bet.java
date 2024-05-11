package app.league1x2.core.betting;

import java.text.MessageFormat;

public class Bet {
    private final String id;
    private final String name;
    private final String selection;
    private final Double odd;

    public Bet(String id, String name, String selection, Double odd) {
        this.id = id;
        this.name = name;
        this.selection = selection;
        this.odd = odd;
    }

    public String getId() {
        return id;
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
                "Bet'{'id=''{0}'', name=''{1}'', selection=''{2}'', odd={3}'}'",
                id, name, selection, odd);
    }
}
