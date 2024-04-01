
package app.league1x2.gui.panel.input;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BetOddsPanel extends JPanel {
    public final static String[] selections = {"1", "X", "2"};
    private final List<BetOddPanel> betOddPanelsList = new ArrayList<>();

    public BetOddsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        for (String selection : selections) {
            BetOddPanel betOddPanel = new BetOddPanel(selection, 6);
            add(betOddPanel);
            betOddPanelsList.add(betOddPanel);
        }
    }

    public LinkedHashMap<String, Double> getBetOdds() {
        LinkedHashMap<String, Double> betOddsList = new LinkedHashMap<>();
        for (BetOddPanel betOddPanel : betOddPanelsList) {
            betOddsList.put(betOddPanel.getSelection(), betOddPanel.getBetOdd());
        }
        return betOddsList;
    }

}
