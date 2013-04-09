package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;

/**
 *
 * @author daboross
 */
public class FrisbeeHolderSolenoidsExtend extends CommandBase {

    private boolean isFinished;

    public FrisbeeHolderSolenoidsExtend() {
        requires(frisbeeHolderSolenoids);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        frisbeeHolderSolenoids.extend();
        RobotDebugger.push(frisbeeHolderSolenoids);
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}