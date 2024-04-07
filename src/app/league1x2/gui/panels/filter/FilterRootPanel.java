package app.league1x2.gui.panels.filter;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;
import java.awt.*;

public class FilterRootPanel extends JPanel {
    public final FilterTicketsInputPanel filterTicketsInputPanel = new FilterTicketsInputPanel();
    public final FilterTicketsControlPanel filterTicketsControlPanel = new FilterTicketsControlPanel();

    public FilterRootPanel() {
        setPreferredSize(new Dimension(LeagueAppConstants.WIDTH / 4, 0));
        setLayout(new BorderLayout(5, 5));
        add(filterTicketsInputPanel, BorderLayout.NORTH);
        add(filterTicketsControlPanel, BorderLayout.SOUTH);
    }

}
