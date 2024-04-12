package app.league1x2.gui.panels.filters;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;
import java.awt.*;

public class FiltersRootPanel extends JPanel {
    private final JButton resetFiltersButton = new JButton("Reseteaza");
    public final FiltersPanel filtersPanel = new FiltersPanel();
    public final JButton applyFiltersButton = new JButton("Filtreaza");

    public FiltersRootPanel() {
        initResetFiltersButton();
        initApplyFiltersButton();

        setPreferredSize(new Dimension(LeagueAppConstants.WIDTH / 4, 0));
        setLayout(new BorderLayout(5, 5));
        add(resetFiltersButton, BorderLayout.NORTH);
        add(filtersPanel, BorderLayout.CENTER);
        add(applyFiltersButton, BorderLayout.SOUTH);
    }

    private void initResetFiltersButton() {
        resetFiltersButton.setFocusPainted(false);
        resetFiltersButton.addActionListener(event -> {
            filtersPanel.clear();
        });
    }

    private void initApplyFiltersButton() {
        applyFiltersButton.setFocusPainted(false);
    }

}
