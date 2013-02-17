package edu.wpi.first.wpilibj.templates.vstj;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class holds variables about JoySticks.
 *
 * It will give different output (by using different mapping) depending on
 * whether the user has selected to use the XBox controller or the logitech
 * controller.
 */
public class VstJ {

    private static Joystick[] joySticks;

    protected static void joyStickInit() {
        joySticks = new Joystick[2];
        for (int i = 0; i < joySticks.length; i++) {
            joySticks[i] = new Joystick(i);
        }
    }

    private static Joystick getJoystick(int number) {
        if (number < 0 || number > 2) {
            throw new IllegalArgumentException("To High/Low number for getJoystick()");
        }
        return joySticks[number];
    }

    public static Joystick getDriveJoystick() {
        return getJoystick(FV.DRIVE_JOYSTICK);
    }
    public static Joystick getShooterJoystick(){
        return getJoystick(FV.SHOOTER_JOYSTICK);
    }

    public static double getLadderControlAxisValue() {
        return getJoystickAxis(Mappings.ladderControlAxisJoystickNumber, Mappings.ladderControlAxisNumber);
    }

    public static boolean getShooterSolenoidPushButtonValue() {
        return getJoystickButton(Mappings.shooterSolenoidButtonJoystickNumber, Mappings.shooterMotorSpeedDownButtonNumber);
    }

    public static boolean getShooterMotorSpeedUpButtonValue() {
        return getJoystickButton(Mappings.shooterMotorSpeedUpButtonJoystickNumber, Mappings.shooterMotorSpeedUpButtonNumber);
    }

    public static boolean getShooterMotorSpeedDownButtonValue() {
        return getJoystickButton(Mappings.shooterMotorSpeedDownButtonJoystickNumber, Mappings.shooterMotorSpeedDownButtonNumber);
    }

    public static boolean getDriveSpeedToggleButtonValue() {
        return getJoystickButton(Mappings.driveSpeedToggleButtonJoystickNumber, Mappings.driveSpeedToggleButtonNumber);
    }

    public static boolean getClimberArmStartToggleButtonValue() {
        return getJoystickButton(Mappings.climberArmSolenoidStartButtonJoystickNumber, Mappings.climberArmSolenoidStartButtonNumber);
    }

    private static boolean getJoystickButton(int joyStick, int buttonNumber) {
        return getJoystick(joyStick).getRawButton(buttonNumber);
    }

    private static double getJoystickAxis(int joyStick, int axisNumber) {
        return getJoystick(joyStick).getRawAxis(axisNumber);
    }

    /**
     * Mappings for joysticks.
     */
    private static class Mappings {
        //

        protected static final int climberArmSolenoidStartButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        protected static final int climberArmSolenoidStartButtonNumber = FV.BUTTON.STAND_OF_JOYSTICK.BOTTOM_LEFT;
        //
        protected static final int shooterSolenoidButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        protected static final int shooterSolenoidButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.TRIGGER;
        //
        protected static final int shooterMotorSpeedUpButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        protected static final int shooterMotorSpeedUpButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.RIGHT;
        //
        protected static final int shooterMotorSpeedDownButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        protected static final int shooterMotorSpeedDownButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.LEFT;
        //
        protected static final int driveSpeedToggleButtonJoystickNumber = FV.DRIVE_JOYSTICK;
        protected static final int driveSpeedToggleButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.MIDDLE;
        //
        protected static final int ladderControlAxisJoystickNumber = FV.SHOOTER_JOYSTICK;
        protected static final int ladderControlAxisNumber = FV.AXIS.X;
    }
}