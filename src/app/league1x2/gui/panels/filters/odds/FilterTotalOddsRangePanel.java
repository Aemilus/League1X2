package app.league1x2.gui.panels.filters.odds;

import app.league1x2.core.filter.FilterTotalOddsRange;

import javax.swing.*;
import java.awt.*;

public class FilterTotalOddsRangePanel extends JPanel {
    private final JTextField minTicketOddsTotal = new JTextField(null, 8);
    private final JLabel separator = new JLabel("-");
    private final JTextField maxTicketOddsTotal = new JTextField(null, 8);

    public FilterTotalOddsRangePanel() {
        initComponents();

        setLayout(new BorderLayout(5, 5));
        add(minTicketOddsTotal, BorderLayout.WEST);
        add(separator, BorderLayout.CENTER);
        add(maxTicketOddsTotal, BorderLayout.EAST);
    }

    private void initComponents() {
        initMinTicketOddsTotal();
        initSeparator();
        initMaxTicketOddsTotal();
    }

    private void initMinTicketOddsTotal() {
        minTicketOddsTotal.setMargin(new Insets(2, 4, 2, 4));
        minTicketOddsTotal.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void initSeparator() {
        separator.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void initMaxTicketOddsTotal() {
        maxTicketOddsTotal.setMargin(new Insets(2, 4, 2, 4));
        maxTicketOddsTotal.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public FilterTotalOddsRange getTotalOddsRangeFilter() {
        return new FilterTotalOddsRange(minTicketOddsTotal.getText(), maxTicketOddsTotal.getText());
    }

    public void clear() {
        minTicketOddsTotal.setText(null);
        maxTicketOddsTotal.setText(null);
    }

}
