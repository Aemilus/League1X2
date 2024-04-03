package app.league1x2.gui.panels.tickets.filter;

import javax.swing.*;
import java.awt.*;

public class FilterTicketsPanel extends JPanel {
    public final FilterTicketsInputPanel filterTicketsInputPanel = new FilterTicketsInputPanel();
    public final FilterTicketsControlPanel filterTicketsControlPanel = new FilterTicketsControlPanel();

    public FilterTicketsPanel() {
        setLayout(new BorderLayout(5, 5));
        add(filterTicketsInputPanel, BorderLayout.CENTER);
        add(filterTicketsControlPanel, BorderLayout.EAST);
    }

}
