package app.league1x2.gui.panels.betting.input;

import javax.swing.*;
import java.awt.*;

public class BetNamePanel extends JPanel {
    private static int count = 0;

    private final JTextField betNameTextField;

    public BetNamePanel() {
        betNameTextField = new JTextField("", 20);
        setNextBetName();
        betNameTextField.setMargin(new Insets(2, 4, 2, 4));
        setLayout(new BorderLayout(5, 5));
        add(betNameTextField, BorderLayout.WEST);
    }

    public String getBetName() {
        return betNameTextField.getText();
    }

    public void setNextBetName() {
        count++;
        betNameTextField.setText(STR."Meci \{count}");
    }

}
