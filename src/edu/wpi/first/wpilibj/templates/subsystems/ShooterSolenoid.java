package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunShooterSolenoid;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author Robotics
 */
public class ShooterSolenoid extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Solenoid shooterSolenoid = new Solenoid(VstM.Solenoids.SHOOTER_SOLENOID_PORT);
    
    public void initDefaultCommand() {
        setDefaultCommand(new RunShooterSolenoid());
    }

    public void extend() {
        shooterSolenoid.set(true);
    }
    
    public void retract() {
        shooterSolenoid.set(false);
    }
    
    public void stop() {
        shooterSolenoid.set(false);
    }
}
