package eu.theritual.phisher.rider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    private boolean showLog;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss:S");

    public Utils(boolean logOn) {
        showLog = logOn;
    }

    public void log(String text) {
        if (showLog) {
            LocalDateTime now = LocalDateTime.now();
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
}
