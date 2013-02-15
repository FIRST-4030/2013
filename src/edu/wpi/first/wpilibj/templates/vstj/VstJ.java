package edu.wpi.first.wpilibj.templates.vstj;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class holds variables about JoySticks. It is slightly variable. It holds
 * different joystick configurations.
 */
public class VstJ {
    
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

    public static int getShooterMotorToggleButtonNumber() {
        return FixedMappings.getShooterMotorToggleButtonNumber();
    }

    public static boolean getShooterMotorToggleButtonValue() {
        return FixedMappings.getDefaultJoyStick().getRawButton(FixedMappings.getShooterMotorToggleButtonNumber());
    }
}