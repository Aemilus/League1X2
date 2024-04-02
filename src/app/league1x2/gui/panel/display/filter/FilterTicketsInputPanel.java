package app.league1x2.gui.panel.display.filter;

import javax.swing.*;
import java.awt.*;

public class FilterTicketsInputPanel extends JPanel {
    public final JTextField minTicketOddsTotal = new JTextField("1.00", 10);
    private final JLabel separator = new JLabel("-");
    public final JTextField maxTicketOddsTotal = new JTextField("1.00", 10);

    public FilterTicketsInputPanel() {
        setLayout(new BorderLayout(5, 5));
        minTicketOddsTotal.setMargin(new Insets(2, 4, 2, 4));
        minTicketOddsTotal.setHorizontalAlignment(SwingConstants.CENTER);
        separator.setHorizontalAlignment(SwingConstants.CENTER);
        maxTicketOddsTotal.setMargin(new Insets(2, 4, 2, 4));
        maxTicketOddsTotal.setHorizontalAlignment(SwingConstants.CENTER);
        add(minTicketOddsTotal, BorderLayout.WEST);
        add(separator, BorderLayout.CENTER);
        add(maxTicketOddsTotal, BorderLayout.EAST);
    }

}
