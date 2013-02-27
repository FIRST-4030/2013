package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimberWedgeSolenoid;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author daboross
 */
public class ClimberWedgeSolenoid extends Subsystem implements Debuggable {

    private Solenoid extendingSolenoid, retractingSolenoid;
    private String status = "Not Set";

    public ClimberWedgeSolenoid() {
        System.out.println("SubSystem Created: ClimberWedgeSolenoid");
        extendingSolenoid = new Solenoid(VstM.SOLENOID.CLIMBER_WEDGE_EXTENDING_SIDE);
        retractingSolenoid = new Solenoid(VstM.SOLENOID.CLIMBER_WEDGE_RETRACTING_SIDE);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunClimberWedgeSolenoid());
    }

    /**
     * This sets the ClimberWedgeSolenoid to extend state.
     *
     * To stop extending, call retract() or stayPut().
     */
    public void extend() {
        status = "Extending";
        extendingSolenoid.set(true);
        retractingSolenoid.set(false);
    }

    /**
     * This sets the ClimberWedgeSolenoid to retract state.
     *
     * To stop retracting, call extend() or stayPut().
     */
    public void retract() {
        status = "Retracting";
        retractingSolenoid.set(true);
        extendingSolenoid.set(false);
    }

    /**
     * This sets the ClimberWedgeSolenoid to "stay put" mode.
     */
    public void stayPut() {
        status = "Staying";
        extendingSolenoid.set(false);
        retractingSolenoid.set(false);
    }

    public DebugOutput getStatus() {
        return new DebugStatus("ClimberWedgeSolenoid", status, DebugLevel.HIGH);
    }
}
