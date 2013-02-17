package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimberArmSolenoids;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author daboross
 */
public final class ClimberArmSolenoids extends Subsystem implements Debuggable {

    private Solenoid solenoid1Side1, solenoid1Side2, solenoid2Side1, solenoid2Side2;

    public ClimberArmSolenoids() {
        solenoid1Side1 = new Solenoid(VstM.Solenoids.CLIMBER_ARM_1_SIDE_1);
        solenoid1Side2 = new Solenoid(VstM.Solenoids.CLIMBER_ARM_1_SIDE_2);
        solenoid2Side1 = new Solenoid(VstM.Solenoids.CLIMBER_ARM_2_SIDE_1);
        solenoid2Side2 = new Solenoid(VstM.Solenoids.CLIMBER_ARM_2_SIDE_2);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunClimberArmSolenoids());
    }
    private String state = "None Set";

    public void extend() {
        solenoid1Side1.set(true);
        solenoid1Side2.set(false);
        solenoid2Side1.set(true);
        solenoid2Side2.set(false);
        state = "Extend Slow";
    }

    public void retract() {
        solenoid1Side1.set(false);
        solenoid1Side2.set(true);
        solenoid2Side1.set(false);
        solenoid2Side2.set(false);
        state = "Retract Fast";
    }

    public DebugOutput getStatus() {
        return new InfoState("ClimberArmSolenoids", state);
    }
}
