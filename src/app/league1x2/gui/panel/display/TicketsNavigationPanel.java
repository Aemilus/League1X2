package app.league1x2.gui.panel.display;

import javax.swing.*;
import java.awt.*;

public class TicketsNavigationPanel extends JPanel {
    public JButton backwardButton = new JButton("<<");
    public JTextField currentTicketTextField = new JTextField("0/0", 15);
    public JButton forwardButton = new JButton(">>");

    public TicketsNavigationPanel() {
        initBackwardButton();
        initCurrentTicketTextField();
        initForwardButton();
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
