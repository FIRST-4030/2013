/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TowerClimb extends CommandBase {
    
    private boolean isDone = false;
    
    public TowerClimb() {
        requires(towerClimbMotors);
    }

    // Called just before this Command runs the first time.
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run.
    protected void execute() {
        isDone = true;
        double speed = SmartDashboard.getNumber("TowerClimbSpeed");// TODO: Not Sure If This Is Correct
        towerClimbMotors.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute().
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
        towerClimbMotors.stop();
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}