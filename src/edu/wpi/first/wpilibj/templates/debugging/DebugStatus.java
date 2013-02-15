package edu.wpi.first.wpilibj.templates.debugging;

import edu.wpi.first.wpilibj.templates.HM;

/**
 * Status Report of something.
 */
public class DebugStatus implements DebugInfo {

    private String key;
    private String message;

    public DebugStatus(String key, String message) {
        if (key == null || message == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key;
        this.message = message;
    }

    public DebugStatus(String key, double value) {
        if (key == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key;
        this.message = String.valueOf(HM.round(100, value));
    }

    public DebugStatus(String key, int value) {
        if (key == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        this.key = key;
        this.message = String.valueOf(value);
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