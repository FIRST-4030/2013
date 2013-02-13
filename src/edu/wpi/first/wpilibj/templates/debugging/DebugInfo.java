package edu.wpi.first.wpilibj.templates.debugging;

/**
 * Status Report.
 */
public class DebugInfo {

    private String key;
    private String message;

    public DebugInfo(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public DebugInfo(String key, double value) {
        this.message = String.valueOf(value);
    }

    public DebugInfo(String key, int value) {
        this.message = String.valueOf(value);
    }

    public String key() {
        return key;
    }

    public String message() {
        return message;
    }
}