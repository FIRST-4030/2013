package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.helpers.solenoid.SolenoidPair;
import org.ingrahamrobotics.robot2013.variablestores.VstM;

/**
 * The SubSystem to control the Shoot Solenoids.
 */
public class ShooterSolenoids extends Subsystem {

    private final SolenoidPair shooterSolenoids = new SolenoidPair(VstM.SOLENOID.SHOOTER_EXTENDING_SIDE, VstM.SOLENOID.SHOOTER_RETACTING_SIDE, true);

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

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.MID, "ShooterSolenoids:Extend", shooterSolenoids.getState());
    }
}
