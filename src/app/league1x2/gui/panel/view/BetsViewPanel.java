package app.league1x2.gui.panel.view;

import javax.swing.*;
import java.awt.*;

public class BetsViewPanel extends JPanel {
    private final BetsTableModel betsTableModel = new BetsTableModel();
    private final JTable betsTable = new JTable(betsTableModel);
    private BetsTablePanel betsTablePanel = new BetsTablePanel(betsTable);

    public BetsViewPanel() {
        setLayout(new BorderLayout(5, 5));
        add(betsTablePanel, BorderLayout.CENTER);
    }
}
