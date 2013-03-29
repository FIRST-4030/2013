package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.helpers.solenoid.SolenoidPair;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This is the subSystem for controlling the Solenoids that push out/pull back
 * the climber "arm".
 *
 * @author daboross
 */
public final class ClimberArmSolenoids extends Subsystem implements Debuggable {

    private SolenoidPair climberArmSolenoids = new SolenoidPair(VstM.SOLENOID.CLIMBER_ARM_EXTENDING_SIDE, VstM.SOLENOID.CLIMBER_ARM_RETRACTING_SIDE, false);

    public ClimberArmSolenoids() {
        System.out.println("SubSystem Created: ClimberArmSolenoids");
    }

    protected void initDefaultCommand() {
    }

    public void extend() {
        climberArmSolenoids.extend();
    }

    public void retract() {
        climberArmSolenoids.retract();
    }

    public DebugOutput getStatus() {
        return new InfoState("Ladder Drop State?", climberArmSolenoids.getState(), DebugLevel.HIGH);
    }
}
