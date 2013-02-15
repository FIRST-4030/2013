package edu.wpi.first.wpilibj.templates.vstj;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.HM;

/**
 * Fixed Variables, like button numbers / ports.
 */
class FixedVars {

    protected void intializeJoysticks() {
        if (USING_XBOX) {
            Xbox.initJoyStick();
        } else {
            RegularJoyStick.initJoystick();
        }
    }
    /**
     * Whether to use the XBox controller or the Regular Joy Stick.
     */
    protected static final boolean USING_XBOX = true;

    /**
     * This is the XBox controller.
     */
    protected static class Xbox {

        protected static final int PORT = 1;
        protected static final int LEFT_X_AXIS = 1;
        protected static final int LEFT_Y_AXIS = 2;
        protected static final int TRIGGERS_AXIS = 3;
        protected static final int RIGHT_X_AXIS = 4;
        protected static final int RIGHT_Y_AXIS = 5;
        protected static final int A_BUTTON = 1;
        protected static final int B_BUTTON = 2;
        protected static final int X_BUTTON = 3;
        protected static final int Y_BUTTON = 4;
        private static Joystick JOYSTICK;

        protected static void initJoyStick() {
            JOYSTICK = new Joystick(PORT);
        }

        protected static double getLeftXAxis() {
            return HM.round(JOYSTICK.getRawAxis(LEFT_X_AXIS));
        }

        protected static double getLeftYAxis() {
            return HM.round(JOYSTICK.getRawAxis(LEFT_Y_AXIS));
        }

        protected static double getRightXAxis() {
            return HM.round(JOYSTICK.getRawAxis(RIGHT_X_AXIS));
        }

        protected static double getRightYAxis() {
            return HM.round(JOYSTICK.getRawAxis(RIGHT_Y_AXIS));
        }

        protected static double getTriggerAxis() {
            return HM.round(JOYSTICK.getRawAxis(TRIGGERS_AXIS));
        }

        protected static boolean getAButton() {
            return JOYSTICK.getRawButton(A_BUTTON);
        }

        protected static boolean getBButton() {
            return JOYSTICK.getRawButton(B_BUTTON);
        }

        protected static boolean getXButton() {
            return JOYSTICK.getRawButton(X_BUTTON);
        }

        protected static boolean getYButton() {
            return JOYSTICK.getRawButton(Y_BUTTON);
        }
    }

    /**
     * This is the regular First joystick, then original one.
     */
    protected static class RegularJoyStick {

        protected static final int PORT = 1;
        protected static final int X_AXIS = 1;
        protected static final int Y_AXIS = 2;
        protected static final int TRIGGER_BUTTON = 1;
        protected static Joystick JOYSTICK;

        protected static void initJoystick() {
            JOYSTICK = new Joystick(PORT);
        }

        protected static double getXAxis() {
            return HM.round(JOYSTICK.getRawAxis(X_AXIS));
        }

        protected static double getYAxis() {
            return HM.round(JOYSTICK.getRawAxis(Y_AXIS));
        }

        protected static boolean getTriggerButton() {
            return JOYSTICK.getRawButton(TRIGGER_BUTTON);
        }
    }
}
