package app.league1x2.gui.panels.tickets.navigate;

import javax.swing.*;
import java.awt.*;

public class TicketsNavigationPanel extends JPanel {
    public JButton backwardButton = new JButton("<<");
    public JTextField currentTicketTextField = new JTextField("0/0", 15);
    public JButton forwardButton = new JButton(">>");
    public JTextField currentTicketTotalOddsTextField= new JTextField("", 15);

    public TicketsNavigationPanel() {
        initBackwardButton();
        initCurrentTicketTextField();
        initForwardButton();
        initCurrentTicketTotalOddsTextField();
        placeComponents();
    }

    private void placeComponents() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(backwardButton, BorderLayout.WEST);
        panel.add(currentTicketTextField, BorderLayout.CENTER);
        panel.add(forwardButton, BorderLayout.EAST);

        setLayout(new BorderLayout(5, 5));
        add(panel, BorderLayout.CENTER);
        add(currentTicketTotalOddsTextField, BorderLayout.EAST);
    }

    private void initBackwardButton() {
        backwardButton.setFocusPainted(false);
    }

    private void initCurrentTicketTextField() {
        currentTicketTextField.setMargin(new Insets(2, 4, 2, 4));
        currentTicketTextField.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void initForwardButton() {
        forwardButton.setFocusPainted(false);
    }

    private void initCurrentTicketTotalOddsTextField() {
        currentTicketTotalOddsTextField.setMargin(new Insets(2, 4, 2, 4));
        currentTicketTotalOddsTextField.setHorizontalAlignment(SwingConstants.CENTER);
        currentTicketTotalOddsTextField.setEditable(false);
    }

}
