package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.GroundDriveCommand;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
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

    public void driveWithDefaultController() {
        driveWithController(VstJ.getDefaultJoystick());
    }

    public void driveWithController(Joystick js) {
        roboDrive.arcadeDrive(js);
    }

    /**
     * Get Current Status Info.
     */
    public DebugInfoGroup getStatus() {
        DebugStatus[] infoList = new DebugStatus[2];
        infoList[0] = new DebugStatus("GroundDrive:LeftMotor:Speed", leftMotor.get());
        infoList[1] = new DebugStatus("GroundDrive:RightMotor:Speed", rightMotor.get());
        return new DebugInfoGroup(infoList);
    }
}