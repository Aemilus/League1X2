package app.league1x2.gui.panel.view;

import javax.swing.*;
import java.awt.*;

public class BetsViewPanel extends JPanel {
    public final BetsTablePanel betsTablePanel = new BetsTablePanel();

    public BetsViewPanel() {
        setLayout(new BorderLayout(5, 5));
        add(betsTablePanel, BorderLayout.CENTER);
    }
}
