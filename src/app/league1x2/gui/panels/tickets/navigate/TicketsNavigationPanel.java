package app.league1x2.gui.panels.tickets.navigate;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;
import java.awt.*;

public class TicketsNavigationPanel extends JPanel {
    public JButton backwardButton = new JButton(LeagueAppConstants.LEFT_ARROW);
    public JTextField currentTicketTextField = new JTextField(null, 15);
    public JButton forwardButton = new JButton(LeagueAppConstants.RIGHT_ARROW);

    public TicketsNavigationPanel() {
        initBackwardButton();
        initCurrentTicketTextField();
        initForwardButton();
        placeComponents();
    }

    private void placeComponents() {
        setLayout(new BorderLayout(5, 5));
        add(backwardButton, BorderLayout.WEST);
        add(currentTicketTextField, BorderLayout.CENTER);
        add(forwardButton, BorderLayout.EAST);
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

}
