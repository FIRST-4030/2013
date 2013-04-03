package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 *
 * @author daboross
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
        RobotDebugger.push(frisbeeHolderSolenoids);
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
