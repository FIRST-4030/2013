package org.ingrahamrobotics.robot2013.variablestores;

/**
 * This is the main variable store. It holds a lot of things.
 */
public final class VstM {

    /**
     * Solenoid Statics
     */
    public static final class SOLENOID {

        /**
         * Port for the extending side of the shooter solenoids.
         */
        public static final int SHOOTER_EXTENDING_SIDE = 1;

        /**
         * Port for the retracting side of the shooter solenoids.
         */
        public static final int SHOOTER_RETACTING_SIDE = 2;

        /**
         * Port for the extending side of the frisbee holder solenoids.
         */
        public static final int FRISBEE_HOLDER_EXTENDING_SIDE = 4;

        /**
         * Port for the retracting side of the frisbee holder solenoids.
         */
        public static final int FRISBEE_HOLDER_RETRACTING_SIDE = 3;

        /**
         * Port for the extending side of the 10 point climber solenoids.
         */
        public static final int CLIMBER_10_POINT_EXTENDING_SIDE = 5;

        /**
         * Port for the extending side of the 10 point climber solenoids.
         */
        public static final int CLIMBER_10_POINT_RETRACTING_SIDE = 6;
    }

    /**
     * Digital IO Statics
     */
    public static final class DIGITAL_IO {

        /**
         * Port for the pressure switch
         */
        public static final int PRESSURE_SWITCH = 1;
    }

    /**
     * PWM Statics
     */
    public static final class PWM {

        /**
         * Port for the left drive motor
         */
        public static final int LEFT_MOTOR_PORT = 1;

        /**
         * Port for the right drive motor
         */
        public static final int RIGHT_MOTOR_PORT = 2;

        /**
         * Port for the first shooter motor
         */
        public static final int FIRST_SHOOTER_MOTOR_PORT = 4;

        /**
         * Port for the second shooter motor
         */
        public static final int SECOND_SHOOTER_MOTOR_PORT = 5;

        /**
         * Port for the climber ladder motors
         */
        public static final int CLIMBER_MOTOR_PORT = 10;
    }

    /**
     * Relay Statics
     */
    public static final class RELAY {

        /**
         * Port for the compressor spike
         */
        public static final int COMPRESSOR_SPIKE = 1;
    }
}
