package org.ingrahamrobotics.robot2013.debugging;

/**
 * This is an abstract DebugInfo class, use various other classes in the
 * debugging package if you want to create one of these.
 *
 * @author daboross
 */
public abstract class DebugInfo extends DebugOutput {

    protected abstract String key();

    protected abstract String message();

    protected abstract boolean isConsole();

    protected abstract boolean isDashboard();

    protected abstract int debugLevel();

    protected void debug() {
        RobotDebugger.pushInfo(this);
    }
}
