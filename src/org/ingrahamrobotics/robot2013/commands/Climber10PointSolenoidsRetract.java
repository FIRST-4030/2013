package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;

/**
 *
 */
public class Climber10PointSolenoidsRetract extends CommandBase {

    private boolean isFinished;

    public Climber10PointSolenoidsRetract() {
        requires(climber10PointSolenoids);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        climber10PointSolenoids.retract();
        climber10PointSolenoids.outputStatus();
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
