package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

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