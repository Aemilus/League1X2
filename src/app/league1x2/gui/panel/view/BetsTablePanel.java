package app.league1x2.gui.panel.view;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class BetsTablePanel extends JPanel {
    public final BetsTableModel betsTableModel = new BetsTableModel();
    private final JTable betsTable = new JTable(betsTableModel);
    private final BetsTableScrollPane betsTableScrollPane = new BetsTableScrollPane(betsTable);

    public BetsTablePanel() {
        setLayout(new BorderLayout(5, 5));
        add(betsTableScrollPane, BorderLayout.CENTER);
    }
}
