
package app.league1x2.gui.panel.input;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BetOddsPanel extends JPanel {
    private final List<BetOddPanel> betOddPanelsList = new ArrayList<>();

    public BetOddsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        for (int i = 0; i < 3; i++) {
            BetOddPanel betOddPanel = new BetOddPanel(6);
            add(betOddPanel);
            betOddPanelsList.add(betOddPanel);
        }
    }

    public ArrayList<Double> getBetOdds() {
        ArrayList<Double> betOddsList = new ArrayList<>();
        for (BetOddPanel betOddPanel : betOddPanelsList) {
            betOddsList.add(betOddPanel.getBetOdd());
        }
        return betOddsList;
    }

}
