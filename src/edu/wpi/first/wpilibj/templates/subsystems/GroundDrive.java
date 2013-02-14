package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.GroundDriveCommand;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * Robot SubSystem GroundDrive.
 */
public class GroundDrive extends Subsystem implements Debuggable {

    private static Jaguar leftMotor = new Jaguar(VstM.PWM.LEFT_MOTOR_PORT);
    private static Jaguar rightMotor = new Jaguar(VstM.PWM.RIGHT_MOTOR_PORT);
    private static RobotDrive roboDrive;

    public GroundDrive() {
        roboDrive = new RobotDrive(leftMotor, rightMotor);
        roboDrive.stopMotor();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new GroundDriveCommand());
    }

    public void driveWithController(Joystick js) {
        roboDrive.arcadeDrive(js);
    }

    /**
     * Get Current Status Info.
     */
    public DebugInfo getStatus() {
        return new DebugInfo("GroundDrive:Status", "Left Motor Speed:" + leftMotor.get() + " Right Motor Speed:" + rightMotor.get());
    }
}