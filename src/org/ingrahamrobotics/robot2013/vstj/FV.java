package org.ingrahamrobotics.robot2013.vstj;

/**
 * This class contains all public static final integer variables.
 *
 * It stores what buttons/axis on the XBox and Logitech Joysticks correspond to
 * what numbers in getButton or getRawAxis.
 */
public class FV {

    public static final int TANK_DRIVE_LEFT_JOYSTICK = 2;
    public static final int TANK_DRIVE_RIGHT_JOYSTICK = 3;
    public static final int FIRST_POSSIBLE_ARCADE_DRIVE_JOYSTICK = 2;
    public static final int SECOND_POSSIBLE_ARCADE_DRIVE_JOYSTICK = 3;
    public static final int CURRENT_ARCADE_DRIVE_JOYSTICK_PLACEHOLDER = -1;
    public static final int SHOOTER_JOYSTICK = 1;

    public static class CHANGING {

        private static int currentArcadeDriveJoystick = 2;

        public static void setCurrentArcadeDriveJoystick(int currentArcadeDriveJoystick) {
            FV.CHANGING.currentArcadeDriveJoystick = currentArcadeDriveJoystick;
        }

        public static int getCurrentArcadeDriveJoystick() {
            return currentArcadeDriveJoystick;
        }
    }

    public static class AXIS {

        public static final int X = 1;
        public static final int Y = 2;
    }

    public static class BUTTON {

        public static class TOP_OF_JOYSTICK {

            public static final int TRIGGER = 1;
            public static final int BOTTOM = 2;
            public static final int MIDDLE = 3;
            public static final int LEFT = 4;
            public static final int RIGHT = 5;
        }

        public static class STAND_OF_JOYSTICK {

            public static final int LEFT_TOP = 6;
            public static final int LEFT_BOTTOM = 7;
            public static final int BOTTOM_LEFT = 8;
            public static final int BOTTOM_RIGHT = 9;
            public static final int RIGHT_BOTTOM = 10;
            public static final int RIGHT_TOP = 11;
        }
    }
}
