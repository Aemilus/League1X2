package app.league1x2.gui.panels.betting.table;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;

public class BetsTableScrollPane extends JScrollPane {

    public BetsTableScrollPane(JTable betsTable) {
        super(betsTable);
        betsTable.setFillsViewportHeight(true);
        betsTable.getColumnModel().getColumn(0).
                setMinWidth(LeagueAppConstants.FIRST_COLUMN_WIDTH);
    }

}
