package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
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

    public void driveWithXBox() {
        driveWithController(OI.getDriveJoystick());
    }

    public void driveWithController(Joystick js) {
        roboDrive.arcadeDrive(js);
    }

    /**
     * This Just Calls RobotDebugger.push(this).
     */
    public void statusPush() {
        RobotDebugger.push(this);
    }

    /**
     * Get Current Status Info.
     */
    public DebugInfo getStatus() {
        return new DebugInfo("GroundDriveStatus", "Left:" + leftMotor.get() + " Right:" + rightMotor.get());
    }
}