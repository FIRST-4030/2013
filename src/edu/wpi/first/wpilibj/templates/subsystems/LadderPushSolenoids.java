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
public final class LadderPushSolenoids extends Subsystem implements Debuggable {

    private SolenoidPair ladderPushSolenoids = new SolenoidPair(VstM.SOLENOID.CLIMBER_ARM_EXTENDING_SIDE, VstM.SOLENOID.CLIMBER_ARM_RETRACTING_SIDE, false);

    public LadderPushSolenoids() {
        System.out.println("SubSystem Created: ClimberArmSolenoids");
    }

    protected void initDefaultCommand() {
    }

    public void extend() {
        ladderPushSolenoids.extend();
    }

    public void retract() {
        ladderPushSolenoids.retract();
    }

    public DebugOutput getStatus() {
        return new InfoState("LadderPushSolenoids", ladderPushSolenoids.getState(), DebugLevel.HIGH);
    }
}
