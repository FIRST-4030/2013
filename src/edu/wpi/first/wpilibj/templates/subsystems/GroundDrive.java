package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * Robot SubSystem GroundDrive.
 */
public class GroundDrive extends Subsystem {

    private Jaguar leftMotor;
    private Jaguar rightMotor;
    public GroundDrive() {
    }

    public void initDefaultCommand() {
        // setDefaultCommand(new GroundDriveCommand());
    }
}