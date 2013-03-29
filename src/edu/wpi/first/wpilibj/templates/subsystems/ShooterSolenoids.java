package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.helpers.solenoid.SolenoidPair;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * The SubSystem to control the Shoot Solenoids.
 */
public class ShooterSolenoids extends Subsystem implements Debuggable {

    private SolenoidPair shooterSolenoids = new SolenoidPair(VstM.SOLENOID.SHOOTER_EXTENDING_SIDE, VstM.SOLENOID.SHOOTER_RETACTING_SIDE, false);

    public ShooterSolenoids() {
        System.out.println("SubSystem Created: ShooterSolenoids");
    }

    public void initDefaultCommand() {
    }

    public void extend() {
        shooterSolenoids.extend();
    }

    public void retract() {
        shooterSolenoids.retract();
    }

    public DebugOutput getStatus() {
        return new InfoState("ShooterSolenoids:Extended", shooterSolenoids.getState(), DebugLevel.MID);
    }
}
