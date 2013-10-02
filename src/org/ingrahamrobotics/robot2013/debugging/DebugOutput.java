package org.ingrahamrobotics.robot2013.debugging;

/**
 *
 */
public class DebugOutput {

    public final String key;
    public final String message;
    public final DebugLevel level;

    public DebugOutput(String key, String message, DebugLevel level) {
        this.key = key;
        this.message = message;
        this.level = level;
    }
}
