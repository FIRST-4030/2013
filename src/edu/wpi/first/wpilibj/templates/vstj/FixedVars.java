package edu.wpi.first.wpilibj.templates.vstj;

/**
 * Fixed Variables, like button numbers / ports.
 */
final class FixedVars {

    protected static final int PORT1 = 1;
    protected static final int PORT2 = 2;

    /**
     * This is the XBox controller.
     */
    protected static final class Xbox {

        protected static final class AXIS {

            protected static final int LEFT_X = 1;
            protected static final int LEFT_Y = 2;
            protected static final int TRIGGERS = 3;
        }

        protected static final class BUTTON {

            protected static final int A = 1;
            protected static final int B = 2;
            protected static final int X = 3;
            protected static final int Y = 4;
            protected static final int LEFT_TRIGGER = 5;
            protected static final int RIGHT_TRIGGER = 6;
            protected static final int BACK = 7;
            protected static final int START = 8;
            protected static final int LEFT_CIRCLE_PUSH = 9;
            protected static final int RIGHT_CIRCLE_PUSH = 10;
        }
    }

    /**
     * This is the regular First joystick, then original one.
     */
    protected static final class RegularJoyStick {

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
}
