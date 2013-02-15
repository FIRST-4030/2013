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
        if (FixedVars.USING_XBOX) {
            return Xbox.climberAxisNumber;
        } else {
            return RegularJoyStick.climberAxisNumber;
        }
    }

    protected static int getShooterButtonNumber() {
        if (FixedVars.USING_XBOX) {
            return Xbox.shooterButtonNumber;
        } else {
            return RegularJoyStick.shooterButtonNumber;
        }
    }

    /**
     * This is the XBox controller.
     */
    protected static class Xbox {

        protected static final int climberAxisNumber = FixedVars.Xbox.TRIGGERS_AXIS;
        protected static final int shooterButtonNumber = FixedVars.Xbox.A_BUTTON;//TODO Is this what we want?
    }

    /**
     * This is the regular First joystick, then original one.
     */
    private static class RegularJoyStick {

        protected static final int climberAxisNumber = -20;//TODO What is the climber axis number on the regular joy stick?
        protected static final int shooterButtonNumber = FixedVars.RegularJoyStick.TRIGGER_BUTTON;//TODO What is the shooter button number on the regular joy stick?
    }
}
