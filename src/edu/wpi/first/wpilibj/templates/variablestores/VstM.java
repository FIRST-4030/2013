package edu.wpi.first.wpilibj.templates.variablestores;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This is the main variable store.
 */
public class VstM {

    /*
     * Debug controls
     */
    public class Debug {

        public final static boolean DASHBOARD = true;
        public static final boolean CONSOLE = true;
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

        public static final int LEFT_MOTOR_PORT = 9;
        public static final int RIGHT_MOTOR_PORT = 10;
        public final static int TEST_MOTOR_1 = 9;
        public final static int TEST_MOTOR_2 = 10;
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
