package app.league1x2.constants;

public final class LeagueAppConstants {
    public static final boolean DEBUG = true;

    public static final int WIDTH = 900;
    public static final int HEIGHT = 400;
    public static final int FIRST_COLUMN_WIDTH = WIDTH / 6;

    public static final Double VALID_ODDS = Double.parseDouble("1.00");

    public final static String GAME = "Meci";
    public final static String SELECTION = "Selectie";
    public final static String ODDS = "Cota";
    public final static String SELECTION_1 = "1";
    public final static String SELECTION_X = "X";
    public final static String SELECTION_2 = "2";
    public final static String[] SELECTIONS = {SELECTION_1, SELECTION_X, SELECTION_2};

    private LeagueAppConstants() {
        // prevent creating a class instance
    }

}
