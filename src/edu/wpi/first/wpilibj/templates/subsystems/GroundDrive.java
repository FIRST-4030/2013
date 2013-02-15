package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.GroundDriveCommand;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
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

    public void driveWithXBox() {
        driveWithController(CommandBase.oi.getDriveJoystick());
    }

    public void driveWithController(Joystick js) {
        roboDrive.arcadeDrive(js);
    }

    /**
     * Get Current Status Info.
     */
    public DebugInfoGroup getStatus() {
        DebugInfo[] infoList = new DebugInfo[2];
        infoList[0] = new DebugInfo("GroundDrive:LeftMotor:Speed", leftMotor.get());
        infoList[1] = new DebugInfo("GroundDrive:RightMotor:Speed", rightMotor.get());
        return new DebugInfoGroup(infoList);
    }
}