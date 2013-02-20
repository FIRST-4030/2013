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

    public ShooterSolenoid() {
        System.out.println("SubSystem Created: ShooterSolenoid");
    }
    private Solenoid shooterSolenoidSide1 = new Solenoid(VstM.SOLENOID.SHOOTER_SIDE_1);
    private Solenoid shooterSolenoidSide2 = new Solenoid(VstM.SOLENOID.SHOOTER_SIDE_2);

    public void initDefaultCommand() {
        setDefaultCommand(new RunShooterSolenoid());
    }

    public void extend() {
        shooterSolenoidSide1.set(true);
        shooterSolenoidSide2.set(false);
    }

    public void retract() {
        shooterSolenoidSide1.set(false);
        shooterSolenoidSide2.set(true);
    }

    public DebugOutput getStatus() {
        return new DebugStatus("ShooterSolenoid:Extending", shooterSolenoidSide1.get() ? "yes" : "no", DebugLevel.MID);
    }
}
