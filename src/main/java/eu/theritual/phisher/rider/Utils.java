package eu.theritual.phisher.rider;

public class Utils {
    private boolean showLog = false;

    public void log(String text) {
        if (showLog) {
            Class<?> enclosingClass = getClass().getEnclosingClass();
            System.out.println("[LOG] ::: " + text);
        }
    }

    public void setLog(boolean isOn) {
        this.showLog = isOn;
    }
}
