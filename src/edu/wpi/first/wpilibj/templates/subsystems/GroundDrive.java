package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunGroundDrive;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * Robot SubSystem GroundDrive. This is the main Driving SubSystem.
 */
public class GroundDrive extends Subsystem implements Debuggable {

    private boolean driveReversed = false;
    private static Jaguar leftMotor = new Jaguar(VstM.PWM.LEFT_MOTOR_PORT);
    private static Jaguar rightMotor = new Jaguar(VstM.PWM.RIGHT_MOTOR_PORT);
    private static RobotDrive roboDrive;

    public GroundDrive() {
        System.out.println("Created: GroundDrive");
        roboDrive = new RobotDrive(leftMotor, rightMotor);
        roboDrive.stopMotor();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new RunGroundDrive());
    }

    /**
     * Sets a variable that will be multiplied by the input from whatever
     * joystick there is. Must be between 0 and 1.
     */
    public void setSpeedMutliplier(double d, boolean reversed) {
        driveReversed = reversed;
        if (d < 0 || d > 1) {
            throw new IllegalArgumentException();
        }
        multiplier = d * (driveReversed ? -1 : 1);
    }
    private double multiplier;

    public void driveWithDefaultController() {
        driveWithController(VstJ.getDriveJoystick());
    }
    private Joystick lastController;

    /**
     * The values will be changed by the speed multiplier and turn.
     */
    public void driveWithController(Joystick js) {
        if (js == null) {
            return;
        }
        lastController = js;
        double turn = multiplier * js.getX();
        double speed = multiplier * js.getY();
        roboDrive.arcadeDrive(speed, turn);
    }

    /**
     * The values will NOT be changed by the speed multiplier or turn.
     */
    public void driveWithRaw(double speed, double turn) {
        roboDrive.arcadeDrive(speed, turn);
    }

    public void driveWithLast() {
        driveWithController(lastController);
    }

    /**
     * Get Current Status Info.
     */
    public DebugOutput getStatus() {
        DebugStatus[] infoList = new DebugStatus[4];
        infoList[0] = new DebugStatus("GroundDrive:LeftMotor:Speed", leftMotor.get(), DebugLevel.MID);
        infoList[1] = new DebugStatus("GroundDrive:RightMotor:Speed", rightMotor.get(), DebugLevel.MID);
        infoList[2] = new DebugStatus("GroundDrive:Reversed", driveReversed, DebugLevel.HIGHEST);
        infoList[3] = new DebugStatus("GroundDrive:SpeedMultiplier", multiplier, DebugLevel.HIGHEST);
        return new DebugInfoGroup(infoList);
    }

    public void stop() {
        roboDrive.stopMotor();
    }

    public static void disabled() {
        roboDrive.stopMotor();
    }
}