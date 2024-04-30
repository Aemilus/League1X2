package app.league1x2.gui.panels.betting.input;

import javax.swing.*;
import java.awt.*;

public class BetNamePanel extends JPanel {
    private final JTextField betNameTextField = new JTextField(null, 15);

    public BetNamePanel() {
        initBetNameTextField();

        setLayout(new BorderLayout(5, 5));
        add(betNameTextField, BorderLayout.CENTER);
    }

    private void initBetNameTextField() {
        betNameTextField.setMargin(new Insets(2, 4, 2, 4));
    }

    public String getBetName() {
        return betNameTextField.getText().trim();
    }

    public void clear() {
        betNameTextField.setText(null);
    }

}
