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
 * This is the subSystem for the Solenoid controlling the (I can't remember what
 * this word is?) that pushes out the climber "arm".
 *
 * @author daboross
 */
public final class ClimberArmSolenoids extends Subsystem implements Debuggable {

    private Solenoid side1, side2;

    public ClimberArmSolenoids() {
        side1 = new Solenoid(VstM.SOLENOID.CLIMBER_ARM_SIDE_1);
        side2 = new Solenoid(VstM.SOLENOID.CLIMBER_ARM_SIDE_2);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunClimberArmSolenoids());
    }
    private String state = "None Set";

    public void extend() {
        side1.set(true);
        side2.set(false);
        state = "Extend";
    }

    public void retract() {
        side1.set(false);
        side2.set(true);
        state = "Retract";
    }

    public DebugOutput getStatus() {
        return new InfoState("ClimberArmSolenoids", state, DebugLevel.LOW);
    }
}
