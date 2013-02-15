package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 *
 */
public class RunShooterSolenoid extends CommandBase {

    public RunShooterSolenoid() {
        requires(shooterSolenoid);
    }

    protected void initialize() {
        shooterSolenoid.retract();
    }

    protected void execute() {
        if (VstJ.getShooterSolenoidPushButtonValue()) {
            shooterSolenoid.extend();
        } else {
            shooterSolenoid.retract();
        }
        RobotDebugger.push(shooterSolenoid);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
