package org.ingrahamrobotics.robot2013.debugging;

/**
 * These are different debugging levels.
 *
 * LOW should be for things that are displaying what a motor/solenoid "should
 * be".
 *
 * MID should be for things that are displaying what a motor/solenoid is.
 *
 * HIGH+ will almost always be displayed.
 */
public class DebugLevel {

    /**
     * Messages with this level will always be displayed.
     */
    public static final DebugLevel ALWAYS = new DebugLevel(6, "ALWAYS");
    /**
     * Messages with this level will pretty much always be displayed.
     */
    public static final DebugLevel HIGHEST = new DebugLevel(5, "HIGHEST");
    /**
     * Messages with this level will normally always be displayed.
     */
    public static final DebugLevel HIGH = new DebugLevel(4, "HIGH");
    /**
     * Messages with this level won't normally be displayed. But they will be
     * displayed before anything lower.
     */
    public static final DebugLevel MID = new DebugLevel(3, "MID");
    /**
     * Messages with this level won't normally be displayed, they will be
     * displayed in a high debug.
     */
    public static final DebugLevel LOW = new DebugLevel(2, "LOW");
    /**
     * Messages with this level almost never will be displayed.
     */
    public static final DebugLevel LOWEST = new DebugLevel(1, "LOWEST");
    /**
     * Messages with this level will never be displayed.
     */
    public static final DebugLevel NEVER = new DebugLevel(0, "NEVER");
    /**
     * Minimum Debugging Level that shows on the dashboard.
     */
    public static final DebugLevel CURRENT = HIGH;
    /**
     * Maximum Debugging Level that shows on the console.
     */
    public static final DebugLevel CONSOLE = LOW;
    public final int value;
    public final String name;

    public DebugLevel(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
