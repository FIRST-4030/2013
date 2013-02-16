package edu.wpi.first.wpilibj.templates.debugging;

/**
 *
 * @author daboross
 */
public class InfoState implements DebugInfo {

    private String key;
    private String message;

    public InfoState(String owner, String state) {
        this.key = owner+":State";
        this.message=state;
    }

    public String key() {
        return key;
    }

    public String message() {
        return message;
    }

    public boolean isConsole() {
        return false;
    }

    public boolean isDashboard() {
        return true;
    }
}
