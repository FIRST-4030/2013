package edu.wpi.first.wpilibj.templates.vstj;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author daboross
 */
public class FixedMappings {

    private static boolean joyStickInit = false;

    protected static void joyStickInit() {
        if (FixedVars.USING_XBOX) {
            Xbox.init();
        } else {
            RegularJoyStick.init();
        }
    }

    protected static Joystick getDefaultJoyStick() {
        if (!joyStickInit) {
            joyStickInit();
        }
        if (FixedVars.USING_XBOX) {
            return Xbox.defaultJoyStick;
        } else {
            return RegularJoyStick.defaultJoyStick;
        }
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

        protected static final int climberAxisNumber = FixedVars.Xbox.TRIGGERS;
        protected static final int shooterButtonNumber = FixedVars.Xbox.BUTTON_A;//TODO Is this what we want?
        protected static Joystick defaultJoyStick;

        protected static void init() {
            defaultJoyStick = new Joystick(FixedVars.Xbox.PORT);
        }
    }

    /**
     * This is the regular First joystick, then original one.
     */
    private static class RegularJoyStick {

        protected static final int climberAxisNumber = -20;//TODO What is the climber axis number on the regular joy stick?
        protected static final int shooterButtonNumber = -20;//TODO What is the shooter button number on the regular joy stick?
        protected static Joystick defaultJoyStick;

        protected static void init() {
            defaultJoyStick = new Joystick(FixedVars.RegularJoyStick.PORT);
        }
    }
}
