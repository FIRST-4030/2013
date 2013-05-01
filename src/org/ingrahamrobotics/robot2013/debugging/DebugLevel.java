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
 *
 * @author daboross
 */
public class DebugLevel {

    /**
     * Messages with this level will always be displayed.
     */
    public static final int ALWAYS = 6;
    /**
     * Messages with this level will pretty much always be displayed.
     */
    public static final int HIGHEST = 5;
    /**
     * Messages with this level will normally always be displayed.
     */
    public static final int HIGH = 4;
    /**
     * Messages with this level won't normally be displayed. But they will be
     * displayed before anything lower.
     */
    public static final int MID = 3;
    /**
     * Messages with this level won't normally be displayed, they will be
     * displayed in a high debug.
     */
    public static final int LOW = 2;
    /**
     * Messages with this level almost never will be displayed.
     */
    public static final int LOWEST = 1;
    /**
     * Messages with this level will never be displayed.
     */
    public static final int NEVER = 0;
    /**
     * Minimum Debugging Level that shows on the dashboard.
     */
    public static final int CURRENT = HIGH;
    /**
     * Maximum Debugging Level that shows on the console.
     */
    public static final int CONSOLE = LOW;
}
