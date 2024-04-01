package app.league1x2.gui.panel.view;

import javax.swing.*;

public class BetsTableScrollPane extends JScrollPane {

    public BetsTableScrollPane(JTable betsTable) {
        super(betsTable);
        betsTable.setFillsViewportHeight(true);
        betsTable.getColumnModel().getColumn(0).setPreferredWidth(300);
    }

}
