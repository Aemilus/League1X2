package app.league1x2.gui.panels.betting.table;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class BetsTablePanel extends JPanel {
    public final BetsTableModel betsTableModel = new BetsTableModel();
    public final JTable betsTable = new JTable(betsTableModel);
    private final BetsTableScrollPane betsTableScrollPane = new BetsTableScrollPane(betsTable);

    public BetsTablePanel() {
        setLayout(new BorderLayout(5, 5));
        add(betsTableScrollPane, BorderLayout.CENTER);
    }
}
