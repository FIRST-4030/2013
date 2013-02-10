/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 *
 * @author Ingyram
 */
public class ReadPressureSwitch extends CommandBase {
    
    public ReadPressureSwitch() {
        requires(pressureSwitch);
    }

    protected void initialize() {
        VstP.setAtPressure(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        pressureSwitch.checkPressure();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        VstP.setAtPressure(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
