package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunShooterSolenoid;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.helpers.solenoid.SolenoidPair;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * The Solenoid for the shooter. This should be controlled by
 * RunShooterSolenoid.
 */
public class ShooterSolenoid extends Subsystem implements Debuggable {

    private SolenoidPair shooterSolenoids = new SolenoidPair(VstM.SOLENOID.SHOOTER_EXTENDING_SIDE, VstM.SOLENOID.SHOOTER_RETACTING_SIDE);

    public ShooterSolenoid() {
        System.out.println("SubSystem Created: ShooterSolenoid");
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
        return new DebugStatus("ShooterSolenoid:Extending", shooterSolenoids.isExtending(), DebugLevel.MID);
    }
}
