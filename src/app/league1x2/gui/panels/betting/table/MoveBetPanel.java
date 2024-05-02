package app.league1x2.gui.panels.betting.table;

import javax.swing.*;
import java.awt.*;

public class MoveBetPanel extends JPanel {
    public final JButton up = new JButton("<<");
    public final JButton down = new JButton(">>");

    public MoveBetPanel() {
        setLayout(new GridLayout(2, 1));
        add(up);
        add(down);
    }

}
