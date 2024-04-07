
package app.league1x2.gui.panels.betting.input;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BetOddsPanel extends JPanel {
    private final ArrayList<BetOddPanel> betOddPanelsList = new ArrayList<>();

    public BetOddsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        for (String selection : LeagueAppConstants.SELECTIONS) {
            BetOddPanel betOddPanel = new BetOddPanel(selection, 4);
            add(betOddPanel);
            add(Box.createHorizontalStrut(10));
            betOddPanelsList.add(betOddPanel);
        }
    }

    public LinkedHashMap<String, Double> getBetOddsMap() {
        LinkedHashMap<String, Double> betOddsMap = new LinkedHashMap<>();
        for (BetOddPanel betOddPanel : betOddPanelsList) {
            betOddsMap.put(betOddPanel.getSelection(), betOddPanel.getBetOdd());
        }
        return betOddsMap;
    }

}
