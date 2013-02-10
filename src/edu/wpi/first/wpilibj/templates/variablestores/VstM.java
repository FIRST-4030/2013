package edu.wpi.first.wpilibj.templates.variablestores;

/**
 * This is the main variable store.
 */
public class VstM {
    /*
     * Digital input ports
     */

    public class digital {

        public final static int PRESSURE_SWITCH = 1;
    }

    /*
     * Analog input ports
     */
    public class analog {
    }

    /*
     * PWM ports
     */
    public class pwm {

        public final static int TEST_MOTOR_1 = 9;
        public final static int TEST_MOTOR_2 = 10;
    }

    /*
     * Relay ports
     */
    public class relays {

        public final static int COMPRESSOR = 1;
    }

    /*
     * Joystick axes/buttons
     */
    public class joystick {

        public class xbox {

            public final static int PORT = 1;
            public final static int LEFT_X = 1;
            public final static int LEFT_Y = 2;
            public final static int TRIGGERS = 3;
            public final static int RIGHT_X = 4;
            public final static int RIGHT_Y = 5;
        }
    }
}
