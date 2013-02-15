package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunShooter;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * THe Solenoid for the shooter.
 */
public class ShooterSolenoid extends Subsystem implements Debuggable {

    private Solenoid shooterSolenoidSide1 = new Solenoid(VstM.Solenoids.SHOOTER_SOLENOID_SIDE_1);
    private Solenoid shooterSolenoidSide2 = new Solenoid(VstM.Solenoids.SHOOTER_SOLENOID_SIDE_2);

    public void initDefaultCommand() {
        setDefaultCommand(new RunShooter());
    }

    public void extend() {
        shooterSolenoidSide1.set(true);
        shooterSolenoidSide2.set(false);
    }

    public void retract() {
        shooterSolenoidSide1.set(false);
        shooterSolenoidSide2.set(true);
    }

    public DebugInfoGroup getStatus() {
        DebugInfo info = new DebugInfo("ShooterSolenoid:Extending", shooterSolenoidSide1.get() ? "yes" : "no");
        return new DebugInfoGroup(info);
    }
}
