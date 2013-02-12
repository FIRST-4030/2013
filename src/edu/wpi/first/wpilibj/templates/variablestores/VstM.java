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

        public static final int LEFT_MOTOR_PORT = 10; // TODO: WHAT IS THIS PORT?
        public static final int RIGHT_MOTOR_PORT = 11; // TODO: WHAT IS THIS PORT?
        public static final int TOWER_MOTOR_1_PORT = 12; // TODO: WHAT IS THIS PORT?
        public static final int TOWER_MOTOR_2_PORT = 13; // TODO: WHAT IS THIS PORT?
        public final static int TEST_MOTOR_1 = 9;
        public final static int TEST_MOTOR_2 = 10;
        public static final int CLIMBER_MOTOR_1 = 3;
        public static final int CLIMBER_MOTOR_2 = 4;
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
