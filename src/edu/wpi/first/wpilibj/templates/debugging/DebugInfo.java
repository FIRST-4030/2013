package edu.wpi.first.wpilibj.templates.debugging;

/**
 * This is an abstract DebugInfo class, use various other classes in the
 * debugging package if you want to create one of these.
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
