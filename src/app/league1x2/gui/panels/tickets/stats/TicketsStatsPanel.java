package app.league1x2.gui.panels.tickets.stats;

import javax.swing.*;
import java.awt.*;

public class TicketsStatsPanel extends JPanel {
    public final JButton resetFilterTicketsButton = new JButton("Reseteaza");
    public JTextField minTicketTotalOddsTextField= new JTextField(null, 8);
    public JTextField currentTicketTotalOddsTextField = new JTextField(null, 8);
    public JTextField maxTicketTotalOddsTextField= new JTextField(null, 8);

    public TicketsStatsPanel() {
        initResetFilterTicketsButton();
        initMinTicketTotalOddsTextField();
        initCurrentTicketTotalOddsTextField();
        initMaxTicketTotalOddsTextField();
        setLayout(new BorderLayout(5, 5));
        add(resetFilterTicketsButton, BorderLayout.NORTH);
        add(minTicketTotalOddsTextField, BorderLayout.WEST);
        add(currentTicketTotalOddsTextField, BorderLayout.CENTER);
        add(maxTicketTotalOddsTextField, BorderLayout.EAST);
    }

    private void initResetFilterTicketsButton() {
        resetFilterTicketsButton.setFocusPainted(false);
    }

    private void initMinTicketTotalOddsTextField() {
        minTicketTotalOddsTextField.setMargin(new Insets(2, 4, 2, 4));
        minTicketTotalOddsTextField.setHorizontalAlignment(SwingConstants.CENTER);
        minTicketTotalOddsTextField.setEditable(false);
    }

    private void initCurrentTicketTotalOddsTextField() {
        currentTicketTotalOddsTextField.setMargin(new Insets(2, 4, 2, 4));
        currentTicketTotalOddsTextField.setHorizontalAlignment(SwingConstants.CENTER);
        currentTicketTotalOddsTextField.setEditable(false);
    }

    private void initMaxTicketTotalOddsTextField() {
        maxTicketTotalOddsTextField.setMargin(new Insets(2, 4, 2, 4));
        maxTicketTotalOddsTextField.setHorizontalAlignment(SwingConstants.CENTER);
        maxTicketTotalOddsTextField.setEditable(false);
    }
}
