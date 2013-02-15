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

    public static int getShooterButtonNumber() {
        return FixedMappings.getShooterButtonNumber();
    }
}