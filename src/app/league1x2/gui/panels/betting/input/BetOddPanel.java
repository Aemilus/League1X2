package app.league1x2.gui.panels.betting.input;

import javax.swing.*;
import java.awt.*;

public class BetOddPanel extends JPanel {
    public JTextField betOddTextField;
    private final String selection;

    public BetOddPanel(String selection, int columns) {
        this.selection = selection;
        initBetOddTextField(columns);
        setLayout(new BorderLayout(5, 5));
        add(betOddTextField, BorderLayout.CENTER);
    }

    private void initBetOddTextField(int columns) {
        betOddTextField = new JTextField(null, columns);
        betOddTextField.setMargin(new Insets(2, 4, 2, 4));
        betOddTextField.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public String getSelection() {
        return selection;
    }

    public double getBetOdd() {
        try {
            return Double.parseDouble(betOddTextField.getText().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return Double.parseDouble("0.0");
        }
    }
}
