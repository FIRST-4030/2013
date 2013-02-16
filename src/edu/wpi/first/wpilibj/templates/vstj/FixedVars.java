package edu.wpi.first.wpilibj.templates.vstj;

/**
 * Fixed Variables, like button numbers / ports.
 */
class FixedVars {

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
    }

    /**
     * This is the regular First joystick, then original one.
     */
    protected static class RegularJoyStick {

        protected static final int PORT = 1;
        protected static final int X_AXIS = 1;
        protected static final int Y_AXIS = 2;
        protected static final int TRIGGER_BUTTON = 1;
    }
}
