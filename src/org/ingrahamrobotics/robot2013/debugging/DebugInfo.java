package org.ingrahamrobotics.robot2013.debugging;

/**
 * This is an abstract DebugInfo class, use various other classes in the
 * debugging package if you want to create one of these.
 */
public abstract class DebugInfo extends DebugOutput {

    /**
     * @return the string that is the debugging key for this DebugInfo. The key
     * shows what this value represents.
     */
    protected abstract String key();

    /**
     * @return the message of this DebugInfo.
     */
    protected abstract String message();

    /**
     * @return if this DebugInfo should be displayed on the Console
     */
    protected abstract boolean isConsole();

    /**
     * @return if this DebugInfo should be on the Dashboard
     */
    protected abstract boolean isDashboard();

    /**
     * @return The DebugLevel of this Debug Info
     */
    protected abstract int debugLevel();

    /**
     * Calls RobotDebugger.pushInfo(this);
     */
    protected void debug() {
        RobotDebugger.pushInfo(this);
    }
}
