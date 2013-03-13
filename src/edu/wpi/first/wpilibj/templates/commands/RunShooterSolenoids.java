package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.DisableNotifable;
import edu.wpi.first.wpilibj.templates.RobotMain;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

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
        shooterSolenoids.retract();
        RobotMain.addDisableNotifable(this);
    }

    protected void initialize() {
        System.out.println("[RunShooterSolenoids] Started");
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
        System.out.println("[RunShooterSolenoids] Ended");
        shooterSolenoids.extend();
        RobotDebugger.push(shooterSolenoids);
        startTime = -1;
    }

    public void disable() {
        shooterSolenoids.retract();
    }
}
