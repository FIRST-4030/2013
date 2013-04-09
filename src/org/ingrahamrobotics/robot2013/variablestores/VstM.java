package org.ingrahamrobotics.robot2013.variablestores;

/**
 * This is the main variable store. It holds a lot of things.
 */
public final class VstM {

    public static final class SOLENOID {

        public static final int SHOOTER_EXTENDING_SIDE = 1;
        public static final int SHOOTER_RETACTING_SIDE = 2;
        public static final int FRISBEE_HOLDER_EXTENDING_SIDE = 4;
        public static final int FRISBEE_HOLDER_RETRACTING_SIDE = 3;
        public static final int CLIMB_10_POINT_EXTENDING_SIDE = 5;
        public static final int CLIMB_10_POINT_RETRACTING_SIDE = 6;
    }

    public static final class DIGITAL_IO {

        public static final int PRESSURE_SWITCH = 1;
        public static final int LADDER_LOWER_LIMIT_SWITCH = 2;
        public static final int LADDER_UPPER_LIMIT_SWITCH = 3;
        public static final int LADDER_DEPLOY_LIMIT_SWITCH = 4;
    }

    public static final class PWM {

        public static final int LEFT_MOTOR_PORT = 1;
        public static final int RIGHT_MOTOR_PORT = 2;
        public static final int FIRST_SHOOTER_MOTOR_PORT = 4;
        public static final int SECOND_SHOOTER_MOTOR_PORT = 5;
        public static final int CAMERA_SERVO = 6;
        public static final int CLIMBER_MOTOR_PORT = 10;
    }

    public static final class RELAY {

        public static final int COMPRESSOR_SPIKE = 1;
    }
}
