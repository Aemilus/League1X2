package app.league1x2.core.config;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.betting.BetOdds;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Config {

    public static void exportConfig(ArrayList<BetOdds> betOdds, File f) {
        String path = f.getAbsolutePath();
        if (!path.endsWith(LeagueAppConstants.FILE_EXTENSION)) {
            path = MessageFormat.format("{0}{1}", path, LeagueAppConstants.FILE_EXTENSION);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fw = new FileWriter(path)) {
            gson.toJson(betOdds, fw);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<BetOdds> importConfig(File f) {
        ArrayList<BetOdds> betOdds = new ArrayList<>();
        return betOdds;
    }

}
