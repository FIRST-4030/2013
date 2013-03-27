package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 *
 * @author daboross
 */
public class ClimberWedgeSolenoidsOff extends CommandBase {

    private boolean isFinished;

    public ClimberWedgeSolenoidsOff() {
        requires(climberWedgeSolenoids);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        climberWedgeSolenoids.retract();
        RobotDebugger.push(climberWedgeSolenoids);
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}