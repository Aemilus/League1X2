package app.league1x2.gui.panels.filters;

import app.league1x2.gui.panels.filters.odds.FilterTotalOddsRangePanel;
import app.league1x2.gui.panels.filters.selection.FilterSelectionsPanel;

import javax.swing.*;
import java.awt.*;

public class FiltersPanel extends JPanel {
    public final FilterTotalOddsRangePanel filterTotalOddsRangePanel = new FilterTotalOddsRangePanel();
    public final FilterSelectionsPanel filterSelectionsPanel = new FilterSelectionsPanel();

    public FiltersPanel() {
        setLayout(new BorderLayout(5, 5));
        add(filterTotalOddsRangePanel, BorderLayout.NORTH);
        add(filterSelectionsPanel, BorderLayout.CENTER);
    }

    public void clear() {
        filterTotalOddsRangePanel.clear();
        filterSelectionsPanel.clear();
    }

}
