
package app.league1x2.gui;

import app.league1x2.gui.frame.LeagueFrame;

import javax.swing.*;

public class LeagueGUI {
    public final LeagueFrame frame = new LeagueFrame();

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exception) {
            // if desired L&F is unavailable then do nothing
        }
    }

    public void draw() {
        setLookAndFeel();
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

}
