package edu.wpi.first.wpilibj.templates.vstj;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class holds variables about JoySticks. It is slightly variable. It holds
 * different joystick configurations.
 */
public class VstJ {

    public static final boolean USING_XBOX = false;

    public static Joystick getDefaultJoystick() {
        return FixedMappings.getDefaultJoyStick();
    }

    public static int getClimberAxisNumber() {
        return FixedMappings.getClimberAxisNumber();
    }

    public static double getClimberAxisValue() {
        return FixedMappings.getDefaultJoyStick().getRawAxis(FixedMappings.getClimberAxisNumber());
    }

    public static int getShooterSolenoidPushButtonNumber() {
        return FixedMappings.getShooterSolenoidPushButtonNumber();
    }

    public static boolean getShooterSolenoidPushButtonValue() {
        return FixedMappings.getDefaultJoyStick().getRawButton(FixedMappings.getShooterSolenoidPushButtonNumber());
    }

    public static int getShooterMotorSpeedUpButtonNumber() {
        return FixedMappings.getShooterMotorSpeedUpButtonNumber();
    }

    public static boolean getShooterMotorSpeedUpButtonValue() {
        return FixedMappings.getDefaultJoyStick().getRawButton(FixedMappings.getShooterMotorSpeedUpButtonNumber());
    }

    public static boolean getShooterMotorSpeedDownButtonValue() {
        return FixedMappings.getDefaultJoyStick().getRawButton(FixedMappings.getShooterMotorSpeedDownButtonNumber());
    }

    public static int getShooterMotorSpeedDownButtonNumber() {
        return FixedMappings.getShooterMotorSpeedDownButtonNumber();
    }

    public static int getDriveSpeedToggleButtonNumber() {
        return FixedMappings.getDriveSpeedToggleButtonNumber();
    }

    public static boolean getDriveSpeedToggleButtonValue() {
        return FixedMappings.getDefaultJoyStick().getRawButton(FixedMappings.getDriveSpeedToggleButtonNumber());
    }
}