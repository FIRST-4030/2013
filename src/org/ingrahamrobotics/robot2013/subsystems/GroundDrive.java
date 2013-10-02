package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.commands.grounddrive.RunGroundDrive;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.variablestores.VstM;
import org.ingrahamrobotics.robot2013.vstj.VstJ;

/**
 * Robot SubSystem GroundDrive. This is the main Driving SubSystem.
 */
public class GroundDrive extends Subsystem {

    private boolean driveReversed = false;
    private static final Jaguar leftMotor = new Jaguar(VstM.PWM.LEFT_MOTOR_PORT);
    private static final Jaguar rightMotor = new Jaguar(VstM.PWM.RIGHT_MOTOR_PORT);
    private static final RobotDrive roboDrive = new RobotDrive(leftMotor, rightMotor);

    static {
        roboDrive.setSafetyEnabled(false);
        roboDrive.stopMotor();
    }

    public GroundDrive() {
        System.out.println("SubSystem Created: GroundDrive");
    }

    public void initDefaultCommand() {
        setDefaultCommand(new RunGroundDrive());
    }

    /**
     * Sets a variable that will be multiplied by the input from whatever
     * joystick there is. Must be between 0 and 1.
     *
     * @param d The speed multiplier
     * @param reversed Whether or not the motors should be reversed.
     */
    public void setSpeedMutliplier(double d, boolean reversed) {
        driveReversed = reversed;
        if (d < 0 || d > 1) {
            throw new IllegalArgumentException();
        }
        multiplier = d;
    }
    private double multiplier;

    public void arcadeDriveRefresh() {
        arcadeDriveRefresh(VstJ.getArcadeDriveJoystick());
    }

    public void tankDriveRefresh() {
        tankDriveRefresh(VstJ.getTankDriveLeftJoystick(), VstJ.getTankDriveRightJoystick());
    }

    /**
     * The values will be changed by the speed multiplier and turn.
     */
    private void arcadeDriveRefresh(Joystick js) {
        if (js == null) {
            return;
        }
        double turn = (js.getX() * multiplier);
        double speed = (js.getY() * multiplier * (driveReversed ? -1 : 1));
        roboDrive.arcadeDrive(speed, turn);
    }

    private void tankDriveRefresh(Joystick leftJoystick, Joystick rightJoystick) {
        double leftSpeed = (leftJoystick.getY() * multiplier * (driveReversed ? -1 : 1));
        double rightSpeed = (rightJoystick.getY() * multiplier * (driveReversed ? -1 : 1));
        if (driveReversed) {
            roboDrive.tankDrive(rightSpeed, leftSpeed);
        } else {
            roboDrive.tankDrive(leftSpeed, rightSpeed);
        }
    }

    /**
     * The values will NOT be changed by the speed multiplier or turn.
     *
     * @param speed The speed for arcadeDrive
     * @param turn The turn for the arcadeDrive
     */
    public void arcadeDriveWithRaw(double speed, double turn) {
        roboDrive.arcadeDrive(speed, turn);
    }

    public void stop() {
        roboDrive.stopMotor();
    }

    public static void disabled() {
        roboDrive.stopMotor();
    }

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.MID, "GroundDrive:LeftMotor:Speed", leftMotor.get());
        RobotDebugger.output(DebugLevel.MID, "GroundDrive:RightMotor:Speed", rightMotor.get());
        RobotDebugger.output(DebugLevel.MID, "GroundDrive:Reversed", driveReversed);
        RobotDebugger.output(DebugLevel.MID, "GroundDrive:SpeedMultiplier", multiplier);
    }
}
