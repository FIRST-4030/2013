package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;

/**
 *
 * @author daboross
 */
public class Climber10PointSolenoidsExtend extends CommandBase {

    private boolean isFinished;

    public Climber10PointSolenoidsExtend() {
        requires(climber10PointSolenoids);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        climber10PointSolenoids.extend();
        RobotDebugger.push(climber10PointSolenoids);
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
