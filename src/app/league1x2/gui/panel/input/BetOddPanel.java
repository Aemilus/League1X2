package app.league1x2.gui.panel.input;

import javax.swing.*;
import java.awt.*;

public class BetOddPanel extends JPanel {
    private JTextField betOddTextField;
    private final String selection;

    public BetOddPanel(String selection, int columns) {
        this.selection = selection;
        initBetOddTextField(columns);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createHorizontalStrut(5));
        add(betOddTextField);
    }

    private void initBetOddTextField(int columns) {
        betOddTextField = new JTextField("", columns);
        betOddTextField.setMargin(new Insets(2, 4, 2, 4));
        betOddTextField.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public String getSelection() {
        return selection;
    }

    public double getBetOdd() {
        try {
            return Double.parseDouble(betOddTextField.getText());
        } catch (NumberFormatException e) {
            return Double.parseDouble("0.0");
        }
    }
}
