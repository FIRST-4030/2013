package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * Read the limit switch and set VstM.Climber.climberState according to the limit switches.
 */
public class ReadLimitSwitch extends CommandBase {

    public ReadLimitSwitch() {
        requires(climberLimitSwitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (VstM.Climber.climberState() == -1 && climberLimitSwitch.readLower()) {
            VstM.Climber.setClimberState(0);// TODO Should This Be 1 or 0?
        }
        if (VstM.Climber.climberState() == 1 && climberLimitSwitch.readUpper()) {
            VstM.Climber.setClimberState(0);// TODO Should This Be 1 or 0?
        }
        /*
         * Kept Old Code:
         if (VstM.Climber.isRetracting) {
         if (climberLimitSwitch.readLower()) {
         VstM.Climber.isRetracting = false;
         }
         } else {
         if (climberLimitSwitch.readUpper()) {
         VstM.Climber.isRetracting = true;
         }
         }
         */
        RobotDebugger.push(climberLimitSwitch);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
