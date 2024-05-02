package app.league1x2.core.config;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.betting.BetOdds;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.ArrayList;

@SuppressWarnings("CallToPrintStackTrace")
public class Config {

    public static void exportConfig(ArrayList<BetOdds> betOdds, File f) {
        String path = f.getAbsolutePath();
        if (!path.endsWith(LeagueAppConstants.BET_EXTENSION)) {
            path = MessageFormat.format("{0}{1}", path, LeagueAppConstants.BET_EXTENSION);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fw = new FileWriter(path)) {
            gson.toJson(betOdds, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<BetOdds> importConfig(File f) {
        ArrayList<BetOdds> betOdds = new ArrayList<>();

        Gson gson = new Gson();
        Type listOfBetOddsType = new TypeToken<ArrayList<BetOdds>>(){}.getType();

        try (FileReader fr = new FileReader(f)) {
            JsonReader reader = new JsonReader(fr);
            betOdds = gson.fromJson(reader, listOfBetOddsType);
        } catch (Exception e) {
            // includes FileNotFoundException and IOException
            e.printStackTrace();
        }

        return betOdds;
    }

}
