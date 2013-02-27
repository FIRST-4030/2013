package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunShooterSolenoid;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.helpers.solenoid.SolenoidPair;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * The Solenoid for the shooter. This should be controlled by
 * RunShooterSolenoid.
 */
public class ShooterSolenoids extends Subsystem implements Debuggable {

    private SolenoidPair shooterSolenoids = new SolenoidPair(VstM.SOLENOID.SHOOTER_EXTENDING_SIDE, VstM.SOLENOID.SHOOTER_RETACTING_SIDE);

    public ShooterSolenoids() {
        System.out.println("SubSystem Created: ShooterSolenoids");
    }
    public void initDefaultCommand() {
        setDefaultCommand(new RunShooterSolenoid());
    }

    public void extend() {
        shooterSolenoids.extend();
    }

    public void retract() {
        shooterSolenoids.retract();
    }

    public DebugOutput getStatus() {
        return new InfoState("ShooterSolenoids", shooterSolenoids.getState(), DebugLevel.LOW);
    }
}
