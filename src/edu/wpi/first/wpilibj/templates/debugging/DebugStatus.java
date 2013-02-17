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

    public DebugStatus(String key, String message) {
        if (key == null || message == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key + ":Status";
        this.message = message;
    }

    public DebugStatus(String key, double value) {
        if (key == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key + ":Status";
        this.message = String.valueOf(HM.round(100, value));
    }

    public DebugStatus(String key, int value) {
        if (key == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key + ":Status";
        this.message = String.valueOf(value);
    }

    public DebugStatus(String key, boolean value) {
        if (key == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key + ":Status";
        this.message = value ? "Yes" : "No";
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
        return true;
    }
}