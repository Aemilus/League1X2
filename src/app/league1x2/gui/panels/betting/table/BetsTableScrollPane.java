package app.league1x2.gui.panels.betting.table;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;

public class BetsTableScrollPane extends JScrollPane {
    private static final int[] fixedColumns = new int[]{0, 2, 3, 4};

    public BetsTableScrollPane(JTable betsTable) {
        super(betsTable);
        betsTable.setFillsViewportHeight(true);

        for (int fixedColumn : fixedColumns) {
            betsTable.getColumnModel().getColumn(fixedColumn).setMinWidth(LeagueAppConstants.ODD_COLUMN_WIDTH);
            betsTable.getColumnModel().getColumn(fixedColumn).setMaxWidth(LeagueAppConstants.ODD_COLUMN_WIDTH);
        }

        betsTable.getColumnModel().getColumn(LeagueAppConstants.GAME_COLUMN_INDEX).
                setMinWidth(LeagueAppConstants.GAME_COLUMN_WIDTH);
    }

}
