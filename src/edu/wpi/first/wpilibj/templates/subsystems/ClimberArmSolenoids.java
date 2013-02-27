package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimberArmSolenoids;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This is the subSystem for the Solenoid controlling the ? that pushes out the
 * climber "arm".
 *
 * @author daboross
 */
public final class ClimberArmSolenoids extends Subsystem implements Debuggable {

    private Solenoid extendingSolenoid, retractingSolenoid;

    public ClimberArmSolenoids() {
        System.out.println("SubSystem Created: ClimberArmSolenoids");
        extendingSolenoid = new Solenoid(VstM.SOLENOID.CLIMBER_ARM_EXTENDING_SIDE);
        retractingSolenoid = new Solenoid(VstM.SOLENOID.CLIMBER_ARM_RETRACTING_SIDE);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunClimberArmSolenoids());
    }
    private String state = "None Set";

    public void extend() {
        extendingSolenoid.set(true);
        retractingSolenoid.set(false);
        state = "Extend";
    }

    public void retract() {
        extendingSolenoid.set(false);
        retractingSolenoid.set(true);
        state = "Retract";
    }

    public DebugOutput getStatus() {
        return new InfoState("ClimberArmSolenoids", state, DebugLevel.LOW);
    }
}
