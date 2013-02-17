package edu.wpi.first.wpilibj.templates.variablestores;

import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;

/**
 * This is the main variable store. It holds a lot of things.
 */
public class VstM {

    /**
     * Solenoid controls.
     */
    public class Solenoids {

        public final boolean shooterExtended = false;
        public static final int SHOOTER_SOLENOID_SIDE_1 = 1;
        public static final int SHOOTER_SOLENOID_SIDE_2 = 2;
        public static final int CLIMBER_ARM_1_SIDE_1 = 3;
        public static final int CLIMBER_ARM_1_SIDE_2 = 4;
        public static final int CLIMBER_ARM_2_SIDE_1 = 5;
        public static final int CLIMBER_ARM_2_SIDE_2 = 6;
        public static final int SHOOTER_DUMP_SOLENOID_SIDE_1 = 7;
        public static final int SHOOTER_DUMP_SOLENOID_SIDE_2 = 8;
    }

    /**
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
        /**
         * This is the minimum level a report has to be in order to be pushed.
         * Always Use DebugLevel.LEVELNAME
         */
        public static final int DEBUG_LEVEL = DebugLevel.HIGH;
    }

    /**
     * Digital input ports.
     */
    public class Digital {

        public static final int PRESSURE_SWITCH = 1;
    }

    /**
     * Analog input ports.
     */
    public class Analog {
    }

    /**
     * PWM ports.
     */
    public class PWM {

        public static final int LEFT_MOTOR_PORT = 1;
        public static final int RIGHT_MOTOR_PORT = 2;
        public static final int CLIMBER_MOTOR_PORT = 10;
        public static final int FIRST_SHOOTER_MOTOR_PORT = 4;
        public static final int SECOND_SHOOTER_MOTOR_PORT = 5;
        public static final int TEST_MOTOR_1_PORT = 5;
        public static final int TEST_MOTOR_2_PORT = 6;
    }

    /**
     * Relay ports.
     */
    public class Relays {

        public static final int COMPRESSOR = 1;
        public final static int CLIMBER_LOWER_LIMIT_SWITCH = 2;
        public final static int CLIMBER_UPPER_LIMIT_SWITCH = 3;
    }

    /**
     * This Class Holds Variables For The Climber.
     */
    public static class Climber {

        /**
         * This represents whether or not the Climber is enabled, from the input
         * on the SmartDashboardrd.
         */
        public static boolean climberEnabled = false;
    }
}
