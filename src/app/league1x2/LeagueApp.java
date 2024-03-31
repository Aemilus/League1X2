
package app.league1x2;

import app.league1x2.core.LeagueCore;
import app.league1x2.gui.LeagueGUI;

public class LeagueApp {
    private final LeagueCore core = new LeagueCore();
    private final LeagueGUI gui = new LeagueGUI();

    private void start() {
        core.start();
        gui.draw();
    }

    public static void main(String[] args) {
        LeagueApp app = new LeagueApp();
        app.start();
    }
}
