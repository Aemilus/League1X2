
package app.league1x2.gui;

import app.league1x2.gui.frame.LeagueFrame;

import javax.swing.*;

public class LeagueGUI {
    public final LeagueFrame frame = new LeagueFrame();

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception exception) {
            printLookAndFeel();
        }
    }

    private void printLookAndFeel() {
        UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo laf : lafInfo) {
            System.out.println(laf);
        }
    }

    public void draw() {
        setLookAndFeel();
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

}
