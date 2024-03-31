package app.league1x2.gui.panel.view;

import javax.swing.*;

public class BetsTablePanel extends JScrollPane {

    public BetsTablePanel(JTable betsTable) {
        super(betsTable);
        betsTable.setFillsViewportHeight(true);
    }

}
