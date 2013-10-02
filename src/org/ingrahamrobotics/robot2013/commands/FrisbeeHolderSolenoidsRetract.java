package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;

/**
 *
 */
public class FrisbeeHolderSolenoidsRetract extends CommandBase {

    private boolean isFinished;

    public FrisbeeHolderSolenoidsRetract() {
        requires(frisbeeHolderSolenoids);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        frisbeeHolderSolenoids.retract();
        frisbeeHolderSolenoids.outputStatus();
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
