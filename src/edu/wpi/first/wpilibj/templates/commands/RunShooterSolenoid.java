package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * This Command runs the shooter push solenoid according to the input received
 * from VstJ.getShooterSolenoidPushButtonValue().
 */
public class RunShooterSolenoid extends CommandBase {

    public RunShooterSolenoid() {
        requires(shooterSolenoid);
    }

    protected void initialize() {
        shooterSolenoid.retract();
    }

    protected void execute() {
        //If button pressed, retract, otherwise, extend.
        if (VstJ.getShooterSolenoidPushButtonValue()) {
            shooterSolenoid.retract();
        } else {
            shooterSolenoid.extend();
        }
        RobotDebugger.push(shooterSolenoid);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
}
