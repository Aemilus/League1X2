package app.league1x2.gui.menu;

import javax.swing.*;

public class LeagueMenuBar extends JMenuBar {
    public final LeagueFileMenu fileMenu = new LeagueFileMenu();

    public LeagueMenuBar() {
        super();
        add(fileMenu);
    }
}
