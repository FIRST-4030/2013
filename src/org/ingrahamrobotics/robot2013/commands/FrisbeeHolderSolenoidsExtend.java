package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;

/**
 *
 */
public class FrisbeeHolderSolenoidsExtend extends CommandBase {

    private boolean isFinished;

    /**
     * Default Constructor
     */
    public FrisbeeHolderSolenoidsExtend() {
        requires(frisbeeHolderSolenoids);
    }

    /**
     * Initializes this command. (Preparation for execute())
     */
    protected void initialize() {
        isFinished = false;
    }

    /**
     * Execute this command. (Called multiple times through execution)
     */
    protected void execute() {
        frisbeeHolderSolenoids.extend();
        RobotDebugger.push(frisbeeHolderSolenoids);
        isFinished = true;
    }

    /**
     * @return whether or not this command is finished.
     */
    protected boolean isFinished() {
        return isFinished;
    }

    /**
     * Ends this command (Called after isFinished returns true)
     */
    protected void end() {
    }
}
