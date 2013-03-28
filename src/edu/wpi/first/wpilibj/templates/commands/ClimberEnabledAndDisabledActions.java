package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author daboross
 */
public class ClimberEnabledAndDisabledActions {

    public static void climberEnabledActions() {
        CommandBase.dVstShooterMotors.turnOff();
    }

    public static void climberDisabledActions() {
        CommandBase.climberArmSolenoids.retract();
    }
}