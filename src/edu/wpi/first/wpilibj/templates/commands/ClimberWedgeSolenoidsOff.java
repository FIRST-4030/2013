package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;

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
        if (DVstClimber.climberEnabled()) {
            climberWedgeSolenoids.retract();
            RobotDebugger.push(climberWedgeSolenoids);
        }
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}