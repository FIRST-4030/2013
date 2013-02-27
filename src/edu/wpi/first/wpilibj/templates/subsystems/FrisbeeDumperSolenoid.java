package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunFrisbeeDumperSolenoid;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author daboross
 */
public final class FrisbeeDumperSolenoid extends Subsystem {

    private Solenoid extendingSolenoid, retractingSolenoid;

    public FrisbeeDumperSolenoid() {
        System.out.println("SubSystem Created: FrisbeeDumperSolenoid");
        extendingSolenoid = new Solenoid(VstM.SOLENOID.FRISBEE_DUMP_EXTENDING_SIDE);
        retractingSolenoid = new Solenoid(VstM.SOLENOID.FRISBEE_DUMP_RETRACTING_SIDE);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunFrisbeeDumperSolenoid());
    }

    public void startExpand() {
        extendingSolenoid.set(true);
        retractingSolenoid.set(false);
    }

    public void startRetract() {
        extendingSolenoid.set(true);
        retractingSolenoid.set(false);
    }
}
