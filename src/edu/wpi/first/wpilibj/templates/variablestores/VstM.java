package edu.wpi.first.wpilibj.templates.variablestores;

/**
 * This is the main variable store.
 */
public class VstM {

    /*
     * Debug controls.
     */
    public class Debug {

        /**
         * This is the Dashboard debug variable. If DEBUG isn't true then this
         * will not work.
         */
        public static final boolean DASHBOARD = true;
        /**
         * This is the Console debug variable. If DEBUG isn't true then this
         * will not work.
         */
        public static final boolean CONSOLE = true;
        /**
         * This is the main debug variable.
         */
        public static final boolean DEBUG = DASHBOARD || CONSOLE;
    }

    /*
     * Digital input ports
     */
    public class Digital {

        public final static int PRESSURE_SWITCH = 1;
    }

    /*
     * Analog input ports
     */
    public class Analog {
    }

    /*
     * PWM ports
     */
    public class PWM {

        public final static int TEST_MOTOR_1 = 1;
        public final static int TEST_MOTOR_2 = 2;
        public static final int LEFT_MOTOR_PORT = 3;
        public static final int RIGHT_MOTOR_PORT = 4;
        public static final int CLIMBER_MOTOR_1 = 5;
        public static final int CLIMBER_MOTOR_2 = 6;
    }

    /*
     * Relay ports
     */
    public class Relays {

        public final static int COMPRESSOR = 1;
    }

    /*
     * Joystick axes/buttons
     */
    public class Joysticks {

        public class Xbox {

            public final static int PORT = 1;
            public final static int LEFT_X = 1;
            public final static int LEFT_Y = 2;
            public final static int TRIGGERS = 3;
            public final static int RIGHT_X = 4;
            public final static int RIGHT_Y = 5;
        }
    }
}
