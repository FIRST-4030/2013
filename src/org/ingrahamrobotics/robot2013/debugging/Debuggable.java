package org.ingrahamrobotics.robot2013.debugging;

/**
 * Debuggable Interface. Any SubSystem that has a status should implement this.
 * This allows other class (or this class) to use RobotDebugger.push(this)
 * (this) being a Debuggable.
 */
public interface Debuggable {

    /**
     * This should ALWAYS contain a group with the same keys!!!!. (And Levels)
     */
    public DebugOutput getStatus();
}