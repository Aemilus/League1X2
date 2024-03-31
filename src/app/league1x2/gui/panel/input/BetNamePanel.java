package app.league1x2.gui.panel.input;

import javax.swing.*;
import java.awt.*;

public class BetNamePanel extends JPanel {
    private static int count = 0;

    private final JTextField betNameTextField;

    public BetNamePanel() {
        count++;
        betNameTextField = new JTextField(STR."Meci \{count}", 20);
        betNameTextField.setMargin(new Insets(2, 4, 2, 4));
        setLayout(new BorderLayout(5, 5));
        add(betNameTextField, BorderLayout.WEST);
    }

    public String getBetName() {
        return betNameTextField.getText();
    }
}
