package edu.wpi.first.wpilibj.templates.debugging;

/**
 *
 * @author daboross
 */
public abstract class DebugInfo extends DebugOutput {

    public abstract String key();

    public abstract String message();

    public abstract boolean isConsole();

    public abstract boolean isDashboard();

    protected void debug() {
        RobotDebugger.push(this);
    }
}
