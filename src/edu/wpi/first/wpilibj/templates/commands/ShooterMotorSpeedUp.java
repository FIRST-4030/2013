package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstShooterMotors;

/**
 *
 * @author daboross
 */
public class ShooterMotorSpeedUp extends CommandBase {

    private boolean isFinished;

    public ShooterMotorSpeedUp() {
        requires(shooterMotors);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        DVstShooterMotors.addRegularAmount(shooterMotors);
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
