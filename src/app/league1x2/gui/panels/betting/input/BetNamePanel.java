package app.league1x2.gui.panels.betting.input;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;
import java.util.HashSet;

public class BetNamePanel extends JPanel {
    private static final HashSet<Integer> gameIds = new HashSet<>();
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

    private int getNextBetName() {
        int i = 1;
        while (true) {
            if (gameIds.contains(i)) {
                i++;
            } else {
                gameIds.add(i);
                return i;
            }
        }
    }

    public void setNextBetName() {
        int count = getNextBetName();
        String msg = MessageFormat.format("{0}. ", count);
        betNameTextField.setText(msg);
    }

    public void clearGameIds() {
        gameIds.clear();
    }

}
