package edu.wpi.first.wpilibj.templates.vstj;

/**
 * This class contains all protected static final int variables.
 *
 * It stores what buttons/axis on the XBox and Logitech Joysticks correspond to
 * what numbers in getRawButton or getRawAxis.
 */
final class FV {

    protected static final int JOYSTICK_1 = 1;
    protected static final int JOYSTICK_2 = 2;
    protected static final int DRIVE_JOYSTICK = JOYSTICK_2;
    protected static final int SHOOTER_JOYSTICK = JOYSTICK_1;

    protected static class AXIS {

        protected static final int X = 1;
        protected static final int Y = 2;
    }

    protected static class BUTTON {

        protected static final class TOP_OF_JOYSTICK {

            protected static final int TRIGGER = 1;
            protected static final int BOTTOM = 2;
            protected static final int MIDDLE = 3;
            protected static final int LEFT = 4;
            protected static final int RIGHT = 5;
        }

        protected static final class STAND_OF_JOYSTICK {

            protected static final int LEFT_TOP = 6;
            protected static final int LEFT_BOTTM = 7;
            protected static final int BOTTOM_LEFT = 8;
            protected static final int BOTTOM_RIGHT = 9;
            protected static final int RIGHT_BOTTOM = 10;
            protected static final int RIGHT_TOP = 11;
        }
    }
}