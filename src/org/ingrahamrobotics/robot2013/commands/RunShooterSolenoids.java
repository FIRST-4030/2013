package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.DisableNotifable;
import org.ingrahamrobotics.robot2013.RobotMain;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;

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
        RobotDebugger.push(shooterSolenoids);
        shooterSolenoids.retract();
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
        RobotDebugger.push(shooterSolenoids);
        startTime = -1;
    }

    public void disable() {
        shooterSolenoids.extend();
    }
}