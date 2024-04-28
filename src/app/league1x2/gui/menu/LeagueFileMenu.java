package app.league1x2.gui.menu;

import javax.swing.*;

public class LeagueFileMenu extends JMenu {
    public final ConfigFileChooser configFileChooser = new ConfigFileChooser();

    public final ExportMenuItem exportMenuItem = new ExportMenuItem();
    public final ImportMenuItem importMenuItem = new ImportMenuItem();

    public LeagueFileMenu() {
        super("Fisier");
        add(exportMenuItem);
        add(importMenuItem);
    }
}
