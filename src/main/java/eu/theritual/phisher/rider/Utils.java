package eu.theritual.phisher.rider;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    private boolean showLog;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss:S");
    private DateTimeFormatter dtfFull = DateTimeFormatter.ofPattern("DD/MM/YYYY HH:mm:ss:S");
    private String lastLog = "";

    public Utils(boolean logOn) {
        showLog = logOn;
    }

    public Utils() {
        this(true);
    }

    public void log(String text) {
        LocalDateTime now = LocalDateTime.now();
        lastLog = dtfFull.format(now);
        if (showLog) {
            System.out.println("(LOG) [" + dtf.format(now) + "] ::: " + text);
        }
    }

    public static void logS(String text) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss:S");
            LocalDateTime now = LocalDateTime.now();
            System.out.println("(LOG) [" + dtf.format(now) + "] ::: " + text);
    }

    public void setLog(boolean isOn) {
        this.showLog = isOn;
    }

    public String getLastLog() {
        return lastLog;
    }

    public static void save(Deck deck, String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(Paths.get(fileName + ".json").toFile(), deck);
            deck.getUtl().log("File Saved");
        } catch (IOException e) {
            Utils.logS(e.toString());
        }
    }

    public static Deck load(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Loading from file " + fileName);
        try {
            Deck dck = mapper.readValue(new File(fileName + ".json"), Deck.class);
            dck.getUtl().log("Loaded file " + fileName);
            return dck;
        } catch (IOException e) {
            Deck dck = new Deck();
            dck.getUtl().log("Could not load file " + fileName);
            dck.getUtl().log((e.toString()));
            return dck;
        }
    }
}
