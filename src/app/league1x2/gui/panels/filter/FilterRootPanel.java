package app.league1x2.gui.panels.filter;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.gui.panels.filter.control.FilterTicketsControlPanel;
import app.league1x2.gui.panels.filter.range.FilterTicketsRangePanel;
import app.league1x2.gui.panels.filter.selection.FilterSelectionsPanel;

import javax.swing.*;
import java.awt.*;

public class FilterRootPanel extends JPanel {
    public final FilterTicketsRangePanel filterTicketsRangePanel = new FilterTicketsRangePanel();
    public final FilterSelectionsPanel filterSelectionsPanel = new FilterSelectionsPanel();
    public final FilterTicketsControlPanel filterTicketsControlPanel = new FilterTicketsControlPanel();

    public FilterRootPanel() {
        setPreferredSize(new Dimension(LeagueAppConstants.WIDTH / 4, 0));
        setLayout(new BorderLayout(5, 5));
        add(filterTicketsRangePanel, BorderLayout.NORTH);
        add(filterSelectionsPanel, BorderLayout.CENTER);
        add(filterTicketsControlPanel, BorderLayout.SOUTH);
    }

}
