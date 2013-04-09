package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.commands.RunGroundDrive;
import org.ingrahamrobotics.robot2013.debugging.infos.DebugStatus;
import org.ingrahamrobotics.robot2013.debugging.DebugInfoGroup;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.DebugOutput;
import org.ingrahamrobotics.robot2013.debugging.Debuggable;
import org.ingrahamrobotics.robot2013.variablestores.VstM;
import org.ingrahamrobotics.robot2013.vstj.VstJ;

/**
 * Robot SubSystem GroundDrive. This is the main Driving SubSystem.
 */
public class GroundDrive extends Subsystem implements Debuggable {

    private boolean driveReversed = false;
    private static Jaguar leftMotor = new Jaguar(VstM.PWM.LEFT_MOTOR_PORT);
    private static Jaguar rightMotor = new Jaguar(VstM.PWM.RIGHT_MOTOR_PORT);
    private static RobotDrive roboDrive;
    private static final Object ROBODRIVE_LOCK = new Object();

    public GroundDrive() {
        System.out.println("SubSystem Created: GroundDrive");
        synchronized (ROBODRIVE_LOCK) {
            if (roboDrive == null) {
                roboDrive = new RobotDrive(leftMotor, rightMotor);
                roboDrive.setSafetyEnabled(false);
                roboDrive.stopMotor();
            }
        }
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
        multiplier = d;
    }
    private double multiplier;

    public void driveWithDefaultController() {
        driveWithController(VstJ.getDriveJoystick());
    }
    private Joystick lastController;
    private double lastForwardMotion;
    private double lastSpinMotion;

    /**
     * The values will be changed by the speed multiplier and turn.
     */
    public void driveWithController(Joystick js) {
        if (js == null) {
            return;
        }
        lastController = js;
        double turn = (lastSpinMotion = multiplier * js.getX());
        double speed = (lastForwardMotion = multiplier * js.getY() * (driveReversed ? -1 : 1));
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

    public void stop() {
        roboDrive.stopMotor();
    }

    public static void disabled() {
        roboDrive.stopMotor();
    }

    public double getLastForwardMotion() {
        return lastForwardMotion;
    }

    public double getLastSpinMotion() {
        return lastSpinMotion;
    }

    /**
     * Get Current Status Info.
     */
    public DebugOutput getStatus() {
        DebugStatus[] infoList = new DebugStatus[4];
        infoList[0] = new DebugStatus("GroundDrive:LeftMotor:Speed", leftMotor.get(), DebugLevel.MID);
        infoList[1] = new DebugStatus("GroundDrive:RightMotor:Speed", rightMotor.get(), DebugLevel.MID);
        infoList[2] = new DebugStatus("GroundDrive:Reversed", driveReversed, DebugLevel.MID);
        infoList[3] = new DebugStatus("GroundDrive:SpeedMultiplier", multiplier, DebugLevel.MID);
        return new DebugInfoGroup(infoList);
    }
}