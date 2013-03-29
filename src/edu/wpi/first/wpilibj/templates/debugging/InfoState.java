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

    private final String key;
    private final String message;
    private final int level;

    public InfoState(String owner, String state, int level) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner Can't Be Null");
        }
        if (state == null) {
            this.message = "Not Set";
        } else {
            this.message = state;
        }
        this.key = owner + ":State";
        this.level = level;
    }

    protected String key() {
        return key;
    }

    protected String message() {
        return message;
    }

    protected boolean isConsole() {
        return true;
    }

    protected boolean isDashboard() {
        return true;
    }

    protected int debugLevel() {
        return level;
    }
}
