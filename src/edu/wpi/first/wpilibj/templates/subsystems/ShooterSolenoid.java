package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunShooterSolenoid;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * The Solenoid for the shooter. This should be controlled by
 * RunShooterSolenoid.
 */
public class ShooterSolenoid extends Subsystem implements Debuggable {

    private boolean extendlast = false;

    public ShooterSolenoid() {
        System.out.println("SubSystem Created: ShooterSolenoid");
    }
    private Solenoid extendingSolenoidSide1 = new Solenoid(VstM.SOLENOID.SHOOTER_EXTENDING_SIDE);
    private Solenoid retractingSolenoidSide2 = new Solenoid(VstM.SOLENOID.SHOOTER_RETACTING_SIDE);

    public void initDefaultCommand() {
        setDefaultCommand(new RunShooterSolenoid());
    }

    public void extend() {
        extendingSolenoidSide1.set(true);
        retractingSolenoidSide2.set(false);
        extendlast = true;
    }

    public void retract() {
        extendingSolenoidSide1.set(false);
        retractingSolenoidSide2.set(true);
        extendlast = false;
    }

    public DebugOutput getStatus() {
        return new DebugStatus("ShooterSolenoid:Extending", extendlast, DebugLevel.MID);
    }
}
