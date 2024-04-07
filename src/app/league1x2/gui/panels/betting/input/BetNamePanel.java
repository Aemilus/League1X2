package app.league1x2.gui.panels.betting.input;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;

public class BetNamePanel extends JPanel {
    private static int count = 0;

    private final JTextField betNameTextField;

    public BetNamePanel() {
        betNameTextField = new JTextField("", 15);
        setNextBetName();
        betNameTextField.setMargin(new Insets(2, 4, 2, 4));
        setLayout(new BorderLayout(5, 5));
        add(betNameTextField, BorderLayout.CENTER);
    }

    public String getBetName() {
        return betNameTextField.getText();
    }

    public void setNextBetName() {
        count++;
        String msg = MessageFormat.format("Meci {0}", count);
        betNameTextField.setText(msg);
    }

}
