package edu.wpi.first.wpilibj.templates.debugging;

import edu.wpi.first.wpilibj.templates.HM;

/**
 * Status Report of something. This should be used when reporting a variable
 * speed, or the actual state of something, as apposed to the state of a
 * variable in a program.
 *
 * For instance, this should not be used if you are outputting a stored
 * variable.
 *
 * And it SHOULD be used if you are outputting something that is gotten from a
 * motor/switch/something real.
 */
public class DebugStatus extends DebugInfo {

    private String key;
    private String message;
    private int level;

    public DebugStatus(String key, String message, int level) {
        if (level < DebugLevel.NEVER || level > DebugLevel.ALWAYS) {
            throw new IllegalArgumentException("To High/Low of a level");
        }
        if (key == null || message == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key + ":Status";
        this.message = message;
        this.level = level;
    }

    public DebugStatus(String key, double value, int level) {
        if (level < DebugLevel.NEVER || level > DebugLevel.ALWAYS) {
            throw new IllegalArgumentException("To High/Low of a level");
        }
        if (key == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key + ":Status";
        this.message = String.valueOf(HM.round(100, value));
        this.level = level;
    }

    public DebugStatus(String key, int value, int level) {
        if (level < DebugLevel.NEVER || level > DebugLevel.ALWAYS) {
            throw new IllegalArgumentException("To High/Low of a level");
        }
        if (key == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key + ":Status";
        this.message = String.valueOf(value);
        this.level = level;
    }

    public DebugStatus(String key, boolean value, int level) {
        if (level < DebugLevel.NEVER || level > DebugLevel.ALWAYS) {
            throw new IllegalArgumentException("To High/Low of a level");
        }
        if (key == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key + ":Status";
        this.message = value ? "Yes" : "No";
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