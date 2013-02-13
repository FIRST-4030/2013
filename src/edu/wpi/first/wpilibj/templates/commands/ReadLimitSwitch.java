/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author Robotics
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
        if(VstM.Climber.isRetracting) {
            if(climberLimitSwitch.readLower()) {
                VstM.Climber.isRetracting = false;
            }
        } else {
            if(climberLimitSwitch.readUpper()) {
                VstM.Climber.isRetracting = true;
            }
        }
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
