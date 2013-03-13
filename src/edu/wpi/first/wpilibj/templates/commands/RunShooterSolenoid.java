package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 * This Command runs the shooter push solenoid according to the input received
 * from VstJ.getShooterSolenoidPushButtonValue().
 */
public class RunShooterSolenoid extends CommandBase {

    private static final long timeTillDone = 500;
    private long startTime;
    private boolean isFinished;

    public RunShooterSolenoid() {
        requires(shooterSolenoids);
    }

    protected void initialize() {
        shooterSolenoids.retract();
        RobotDebugger.push(shooterSolenoids);
        startTime = System.currentTimeMillis();
    }

    protected void execute() {
        long diff = System.currentTimeMillis() - startTime;
        if (diff > timeTillDone) {
            isFinished = true;
        }
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
        shooterSolenoids.extend();
    }
}
