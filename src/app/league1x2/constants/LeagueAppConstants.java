package app.league1x2.constants;

public final class LeagueAppConstants {
    public static final boolean DEBUG = false;

    public static final String FILE_EXTENSION = "bet";

    public static final String FONT_NAME = "Tahoma";
    public static final int FONT_SIZE = 18;

    public static final int WIDTH = 1400;
    public static final int HEIGHT = 600;
    public static final int FIRST_COLUMN_WIDTH = WIDTH / 5;

    public static final int TABLE_ROW_HEIGHT = 30;

    public static final Double VALID_ODDS = Double.parseDouble("1.00");

    public final static String GAME = "Meci";
    public final static String TICKET = "Bilet";
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
