package app.league1x2.gui.menu;

import app.league1x2.constants.LeagueAppConstants;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.text.MessageFormat;

public class ConfigFileChooser extends JFileChooser {
    String description = MessageFormat.format("*.{0}", LeagueAppConstants.FILE_EXTENSION);
    FileNameExtensionFilter filter  = new FileNameExtensionFilter
            (description, LeagueAppConstants.FILE_EXTENSION);

    public ConfigFileChooser() {
        super();
        setAcceptAllFileFilterUsed(false);
        setMultiSelectionEnabled(false);
        setFileFilter(filter);
    }

}
