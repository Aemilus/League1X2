package app.league1x2.gui.panels.filter.range;

import javax.swing.*;
import java.awt.*;

public class FilterTicketsRangePanel extends JPanel {
    public final JTextField minTicketOddsTotal = new JTextField(null, 8);
    public final JTextField maxTicketOddsTotal = new JTextField(null, 8);

    public FilterTicketsRangePanel() {
        minTicketOddsTotal.setMargin(new Insets(2, 4, 2, 4));
        minTicketOddsTotal.setHorizontalAlignment(SwingConstants.CENTER);
        maxTicketOddsTotal.setMargin(new Insets(2, 4, 2, 4));
        maxTicketOddsTotal.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel separator = new JLabel("-");
        separator.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout(5, 5));
        add(minTicketOddsTotal, BorderLayout.WEST);
        add(separator, BorderLayout.CENTER);
        add(maxTicketOddsTotal, BorderLayout.EAST);
    }

}
