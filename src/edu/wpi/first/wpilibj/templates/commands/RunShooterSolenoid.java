/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author Robotics
 */
public class RunShooterSolenoid extends CommandBase {

    public RunShooterSolenoid() {
        requires(shooterSolenoid);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooterSolenoid.retract();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.getDriveJoystick().getRawButton(VstM.Joysticks.Xbox.BUTTON_1)) {
            shooterSolenoid.extend();
        } else {
            shooterSolenoid.retract();

        }

        RobotDebugger.push(shooterSolenoid);
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
