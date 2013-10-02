package org.ingrahamrobotics.robot2013.debugging;

/**
 * Debuggable Interface. Any SubSystem that has a status should implement this.
 * This allows other class (or this class) to use RobotDebugger.push(this)
 * (this) being a Debuggable.
 */
public interface Debuggable {

    /**
     * @return An output for this debug status. It should always contain the
     * same keys and levels.
     */
    public DebugOutput getStatus();
}
