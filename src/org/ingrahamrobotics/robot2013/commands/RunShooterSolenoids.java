package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.DisableNotifable;
import org.ingrahamrobotics.robot2013.RobotMain;

/**
 * This Command runs the shooter push solenoid according to the input received
 * from VstJ.getShooterSolenoidPushButtonValue().
 */
public class RunShooterSolenoids extends CommandBase implements DisableNotifable {

    private static final long timeTillDone = 500;
    private long startTime = -1;
    private boolean isFinished;

    public RunShooterSolenoids() {
        requires(shooterSolenoids);
        shooterSolenoids.extend();
        RobotMain.addDisableNotifable(this);
    }

    protected void initialize() {
        startTime = System.currentTimeMillis();
        shooterSolenoids.retract();
        shooterSolenoids.outputStatus();
        isFinished = false;
    }

    protected void execute() {
        if (System.currentTimeMillis() - startTime > timeTillDone) {
            isFinished = true;
        }
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
        shooterSolenoids.extend();
        shooterSolenoids.outputStatus();
        startTime = -1;
    }

    public void disable() {
        shooterSolenoids.extend();
    }
}
