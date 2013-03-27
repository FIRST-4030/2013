package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 *
 * @author daboross
 */
public class ClimberWedgeSolenoidsOn extends CommandBase {

    private boolean isFinished;

    public ClimberWedgeSolenoidsOn() {
        requires(climberWedgeSolenoids);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        climberWedgeSolenoids.extend();
        RobotDebugger.push(climberWedgeSolenoids);
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}