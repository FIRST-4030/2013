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
        protected static final int LEFT_X = 1;
        protected static final int LEFT_Y = 2;
        protected static final int TRIGGERS = 3;
        protected static final int RIGHT_X = 4;
        protected static final int RIGHT_Y = 5;
        protected static final int BUTTON_A = 1;//TODO Find Port
        protected static final int BUTTON_B = 2;//TODO Find Port
        protected static final int BUTTON_X = 3;//TODO Find Port
        protected static final int BUTTON_Y = 4;//TODO Find Port
    }

    /**
     * This is the regular First joystick, then original one.
     */
    protected static class RegularJoyStick {

        protected static final int PORT = 1;//TODO Make sure this is correct port.
        //TODO Get more port numbers/button numbers for Regular Joy Stick.
    }
}
