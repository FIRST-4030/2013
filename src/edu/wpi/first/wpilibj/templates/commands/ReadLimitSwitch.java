package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * Read the limit switch and set VstM.Climber.climberState according to the
 * limit switches.  TODO: Include this in RunClimber.
 */
public class ReadLimitSwitch extends CommandBase {

    public ReadLimitSwitch() {
        requires(climberLimitSwitch);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (VstM.Climber.climberState() == -1 && climberLimitSwitch.readLower()) {
            VstM.Climber.setClimberState(0);
        }
        if (VstM.Climber.climberState() == 1 && climberLimitSwitch.readUpper()) {
            VstM.Climber.setClimberState(0);
        }
        RobotDebugger.push(climberLimitSwitch);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
