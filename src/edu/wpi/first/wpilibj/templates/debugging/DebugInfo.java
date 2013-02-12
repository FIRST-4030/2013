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

    public String key() {
        return key;
    }

    public String message() {
        return message;
    }
}