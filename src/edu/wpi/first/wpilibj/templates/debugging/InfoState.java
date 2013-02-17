package edu.wpi.first.wpilibj.templates.debugging;

/**
 * This is a DebugInfo that stores states of things. This will push only to the
 * SmartDashboard, not to console. This should be used for classes that have two
 * or three different "states", each that is identified with a String. For
 * instance, use this with something that has a "Extending" and "Retracting"
 * state.
 *
 * @author daboross
 */
public class InfoState extends DebugInfo {

    private String key;
    private String message;

    public InfoState(String owner, String state) {
        this.key = owner + ":State";
        this.message = state;
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
