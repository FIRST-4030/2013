package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstShooterMotors;

/**
 *
 * @author daboross
 */
public class ShooterMotorSpeedDown extends CommandBase {

    private boolean isFinished;

    public ShooterMotorSpeedDown() {
        requires(shooterMotors);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        DVstShooterMotors.subtractRegularAmount(shooterMotors);
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
