package edu.wpi.first.wpilibj.templates.variablestores;

/**
 * This is the main variable store. It holds a lot of things.
 */
public final class VstM {

    public static final class SOLENOID {

        public static final int SHOOTER_SIDE_1 = 1;
        public static final int SHOOTER_SIDE_2 = 2;
        public static final int CLIMBER_ARM_SIDE_1 = 3;
        public static final int CLIMBER_ARM_SIDE_2 = 4;
        public static final int CLIMBER_WEDGE_SIDE_1 = 5;
        public static final int CLIMBER_WEDGE_SIDE_2 = 6;
        public static final int FRISBEE_DUMP_1 = 7;
        public static final int FRISBEE_DUMP_2 = 8;
    }

    public static final class DIGITAL_IO {

        public static final int PRESSURE_SWITCH = 1;
        public static final int CLIMBER_LOWER_LIMIT_SWITCH = 2;
        public static final int CLIMBER_UPPER_LIMIT_SWITCH = 3;
        public static final int CLIMBER_DEPLOY_LIMIT_SWITCH = 4;
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
