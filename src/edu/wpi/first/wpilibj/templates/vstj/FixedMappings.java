package edu.wpi.first.wpilibj.templates.vstj;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class FixedMappings {

    private static Joystick defaultJoystick;

    protected static void joyStickInit() {
        defaultJoystick = new Joystick(FixedVars.USING_XBOX ? FixedVars.Xbox.PORT : FixedVars.RegularJoyStick.PORT);
    }

    protected static Joystick getDefaultJoyStick() {
        if (defaultJoystick == null) {
            joyStickInit();
        }
        return defaultJoystick;
    }

    protected static int getClimberAxisNumber() {
        return FixedVars.USING_XBOX ? Xbox.climberAxisNumber : RegularJoyStick.climberAxisNumber;
    }

    protected static int getShooterSolenoidPushButtonNumber() {
        return FixedVars.USING_XBOX ? Xbox.solenoidButtonNumber : RegularJoyStick.solenoidButtonNumber;

    }

    protected static int getShooterMotorToggleButtonNumber() {
        return FixedVars.USING_XBOX ? Xbox.shooterMotorToggleButtonNumber : RegularJoyStick.shooterMotorToggleButtonNumber;
    }

    /**
     * This is the XBox controller.
     */
    protected static class Xbox {

        protected static final int climberAxisNumber = FixedVars.Xbox.TRIGGERS_AXIS;
        protected static final int solenoidButtonNumber = FixedVars.Xbox.A_BUTTON;
        protected static final int shooterMotorToggleButtonNumber = FixedVars.Xbox.B_BUTTON;
    }

    /**
     * This is the regular First joystick, then original one.
     */
    private static class RegularJoyStick {

        protected static final int climberAxisNumber = -20;//TODO What is the climber axis number on the regular joy stick?
        protected static final int solenoidButtonNumber = FixedVars.RegularJoyStick.TRIGGER_BUTTON;
        protected static final int shooterMotorToggleButtonNumber = -20;
    }
}
