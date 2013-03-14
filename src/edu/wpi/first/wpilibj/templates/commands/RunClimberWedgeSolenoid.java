package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 *
 * @author daboross
 */
public class RunClimberWedgeSolenoid extends CommandBase {

    public RunClimberWedgeSolenoid() {
        requires(climberWedgeSolenoids);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (DVstClimber.climberEnabled()) {
            double controlValue = VstJ.getClimberWedgeSolenoidControlAxisValue();
            if (controlValue < -0.5) {
                climberWedgeSolenoids.extend();
            } else if (controlValue > 0.5) {
                climberWedgeSolenoids.retract();
            }
        } else {
            climberWedgeSolenoids.retract();
        }
        RobotDebugger.push(climberWedgeSolenoids);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
}
