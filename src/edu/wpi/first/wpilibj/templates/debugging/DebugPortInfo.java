package edu.wpi.first.wpilibj.templates.debugging;

/**
 *
 * @author daboross
 */
public class DebugPortInfo implements DebugInfo {

    private String key;
    private String message;

    public DebugPortInfo(String key, int portNumber) {
        this.key = "PortOf:" + key;
        this.message = String.valueOf(portNumber);
    }

    public String key() {
        return key;
    }

    public String message() {
        return message;
    }

    public boolean isConsole() {
        return true;
    }

    public boolean isDashboard() {
        return false;
    }
}
