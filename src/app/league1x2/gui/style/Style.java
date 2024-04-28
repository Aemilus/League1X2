package app.league1x2.gui.style;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class Style {

    public static void applyStyle() {
        setLookAndFeel();
        setUIFont(new FontUIResource(LeagueAppConstants.FONT_NAME, Font.BOLD, LeagueAppConstants.FONT_SIZE));
    }

    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception exception) {
            printLookAndFeel();
        }
    }

    private static void printLookAndFeel() {
        UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo laf : lafInfo) {
            System.out.println(laf);
        }
    }

    public static void setUIFont (javax.swing.plaf.FontUIResource f){
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }

}
