package org.ingrahamrobotics.robot2013.commands;

/**
 *
 */
public class ShooterMotorSpeedOff extends CommandBase {

    private boolean isFinished;

    public ShooterMotorSpeedOff() {
        requires(shooterMotors);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        dVstShooterMotors.turnOff();
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
