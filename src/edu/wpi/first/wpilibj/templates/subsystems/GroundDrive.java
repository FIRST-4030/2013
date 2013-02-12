package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotDebugger;
import edu.wpi.first.wpilibj.templates.commands.GroundDriveCommand;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * Robot SubSystem GroundDrive.
 */
public class GroundDrive extends Subsystem {

    private Jaguar leftMotor = new Jaguar(VstM.PWM.LEFT_MOTOR_PORT);
    private Jaguar rightMotor = new Jaguar(VstM.PWM.RIGHT_MOTOR_PORT);

    public GroundDrive() {
    }

    public void initDefaultCommand() {
        setDefaultCommand(new GroundDriveCommand());
    }

    public void driveWithXBox() {
        
    }

    public void driveWithController() {
    }

    public void statusPush() {
        RobotDebugger.push("GroundDriveStatus", "Left:" + leftMotor.get() + " Right:" + rightMotor.get());
    }
}