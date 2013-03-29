package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author daboross
 */
public class ShooterMotorSpeedOn extends CommandBase {

    private boolean isFinished;

    public ShooterMotorSpeedOn() {
        requires(shooterMotors);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        dVstShooterMotors.turnOn();
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
