package edu.wpi.first.wpilibj.templates.debugging;

/**
 * Debuggable Interface. Any SubSystem that has a status should implement this.
 */
public interface Debuggable {

    /**
     * This should ALWAYS contain a group with the same keys!!!!.
     */
    public DebugInfoGroup getStatus();
}