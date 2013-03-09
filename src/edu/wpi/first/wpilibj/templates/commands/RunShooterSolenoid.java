package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.DisableNotifable;
import edu.wpi.first.wpilibj.templates.RobotMain;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * This Command runs the shooter push solenoid according to the input received
 * from VstJ.getShooterSolenoidPushButtonValue().
 */
public class RunShooterSolenoid extends CommandBase implements DisableNotifable {

    private boolean pressedSinceEnabled = false;

    public RunShooterSolenoid() {
        RobotMain.addDisableNotifable(this);
        requires(shooterSolenoids);
    }

    protected void initialize() {
        shooterSolenoids.retract();
    }

    protected void execute() {
        //If button pressed, retract, otherwise, extend.
        if (VstJ.getShooterSolenoidPushButtonValue()) {
            pressedSinceEnabled = true;
            shooterSolenoids.retract();
        } else {
            if (pressedSinceEnabled) {
                shooterSolenoids.extend();
            } else {
                shooterSolenoids.retract();
            }
        }
        RobotDebugger.push(shooterSolenoids);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    public void disable() {
        pressedSinceEnabled = false;
    }
}
