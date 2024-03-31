package app.league1x2.gui.panel.input;

import javax.swing.*;
import java.awt.*;

public class BetOddPanel extends JPanel {
    private final JTextField betOddTextField;

    public BetOddPanel(int columns) {
        betOddTextField = new JTextField("", columns);
        betOddTextField.setMargin(new Insets(2, 4, 2, 4));
        betOddTextField.setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createHorizontalStrut(5));
        add(betOddTextField);
    }

    public double getBetOdd() {
        return Double.parseDouble(betOddTextField.getText());
    }

}
