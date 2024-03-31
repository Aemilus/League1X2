
package app.league1x2.gui.frame;

import app.league1x2.core.BetOdds;
import app.league1x2.gui.panel.root.LeagueRootPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LeagueFrame extends JFrame {
    private final LeagueRootPanel rootPanel = new LeagueRootPanel();

    public LeagueFrame() {
        super("League 1x2");
        initFrame();
        initRootPanel();
        pack();
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(650, 350));
        setResizable(true);
        setLocationByPlatform(true);
        setLayout(new BorderLayout(5,5));
        setIcon();
    }

    private void setIcon() {
        URL iconURL = LeagueFrame.class.getResource("/app/league1x2/gui/frame/soccer-player.png");
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
        }
    }

    private void initRootPanel() {
        add(Box.createVerticalStrut(5), BorderLayout.NORTH);
        add(Box.createVerticalStrut(5), BorderLayout.SOUTH);
        add(Box.createHorizontalStrut(5), BorderLayout.EAST);
        add(Box.createHorizontalStrut(5), BorderLayout.WEST);
        add(rootPanel, BorderLayout.CENTER);
    }

    public BetOdds getBetOdds() {
        return rootPanel.getBetOdds();
    }

}
