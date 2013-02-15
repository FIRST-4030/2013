package edu.wpi.first.wpilibj.templates.debugging;

/**
 * Debuggable Interface.
 */
public interface Debuggable {

    /**
     * This should ALWAYS contain a group with the same keys!!!!.
     */
    public DebugInfoGroup getStatus();
}