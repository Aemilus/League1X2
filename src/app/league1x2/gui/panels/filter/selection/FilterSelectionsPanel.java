package app.league1x2.gui.panels.filter.selection;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;
import java.util.ArrayList;

public class FilterSelectionsPanel extends JPanel {
    public final ArrayList<FilterSelectionPanel> filterSelectionPanelsList = new ArrayList<>();

    public FilterSelectionsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(100));
        for (String selection : LeagueAppConstants.SELECTIONS) {
            FilterSelectionPanel filterSelectionPanel = new FilterSelectionPanel(selection);
            add(filterSelectionPanel);
            add(Box.createVerticalStrut(10));
            filterSelectionPanelsList.add(filterSelectionPanel);
        }
        add(Box.createVerticalStrut(100));
    }
}
