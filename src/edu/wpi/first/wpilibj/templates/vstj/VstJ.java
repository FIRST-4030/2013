package edu.wpi.first.wpilibj.templates.vstj;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class allows you to get the values/buttons from the Joysticks.
 */
public class VstJ {

    private static Joystick[] joySticks;

    protected static void joyStickInit() {
        joySticks = new Joystick[2];
        for (int i = 0; i < joySticks.length; i++) {
            joySticks[i] = new Joystick(i + 1);
        }
    }

    private static Joystick getJoystick(int number) {
        if (joySticks == null) {
            joyStickInit();
        }
        if (number < 1 || number > 2) {
            throw new IllegalArgumentException("[VstJ] To High/Low number for getJoystick()");
        }
        return joySticks[number - 1];
    }

    private static JoystickButton getJoystickButton(int joystickNumber, int buttonNumber) {
        return new JoystickButton(getJoystick(joystickNumber), buttonNumber);
    }

    private static double getJoystickAxis(int joyStick, int axisNumber) {
        return getJoystick(joyStick).getRawAxis(axisNumber);
    }

    public static Joystick getDriveJoystick() {
        return getJoystick(FV.DRIVE_JOYSTICK);
    }

    public static Joystick getShooterJoystick() {
        return getJoystick(FV.SHOOTER_JOYSTICK);
    }

    public static double getLadderControlAxisValue() {
        return getJoystickAxis(Mappings.ladderControlAxisJoystickNumber, Mappings.ladderControlAxisNumber);
    }

    public static JoystickButton getShooterSolenoidPushButton() {
        return getJoystickButton(Mappings.shooterSolenoidPushButtonJoystickNumber, Mappings.shooterSolenoidPushButtonNumber);
    }

    public static JoystickButton getShooterMotorOnButton() {
        return getJoystickButton(Mappings.shooterMotorOnButtonJoystickNumber, Mappings.shooterMotorOnButtonNumber);
    }

    public static JoystickButton getShooterMotorOffButton() {
        return getJoystickButton(Mappings.shooterMotorOffButtonJoystickNumber, Mappings.shooterMotorOffButtonNumber);
    }

    public static JoystickButton getDriveSpeedToggleButton() {
        return getJoystickButton(Mappings.driveSpeedToggleButtonJoystickNumber, Mappings.driveSpeedToggleButtonNumber);
    }

    public static JoystickButton getClimberArmSolenoidStartExtendButton() {
        return getJoystickButton(Mappings.climberArmSolenoidStartExtendButtonJoystickNumber, Mappings.climberArmSolenoidStartExtendButtonNumber);
    }

    public static JoystickButton getDriveControlReverseButton() {
        return getJoystickButton(Mappings.driveControlReverseButtonJoystickNumber, Mappings.driveControlReverseButtonNumber);
    }

    public static JoystickButton getFrisbeeDumpButton() {
        return getJoystickButton(Mappings.frisbeeDumpButtonJoystickNumber, Mappings.frisbeeDumpButtonNumber);
    }

    public static JoystickButton getFrisbeeUnDumpButton() {
        return getJoystickButton(Mappings.frisbeeUnDumpButtonJoystickNumber, Mappings.frisbeeUnDumpButtonNumber);
    }

    public static JoystickButton getGroundDriveFastTurnLeftButton() {
        return getJoystickButton(Mappings.groundDriveFastTurnLeftButtonJoystickNumber, Mappings.groundDriveFastTurnLeftButtonNumber);
    }

    public static JoystickButton getGroundDriveFastTurnRightButton() {
        return getJoystickButton(Mappings.groundDriveFastTurnRightButtonJoystickNumber, Mappings.groundDriveFastTurnRightButtonNumber);
    }

    public static JoystickButton getClimberWedgeSolenoidsOnButton() {
        return getJoystickButton(Mappings.climberWedgeSolenoidsOnButtonJoystickNumber, Mappings.climberWedgeSolenoidsOnButtonNumber);
    }

    public static JoystickButton getClimberWedgeSolenoidsOffButton() {
        return getJoystickButton(Mappings.climberWedgeSolenoidsOffButtonJoystickNumber, Mappings.climberWedgeSolenoidsOffButtonNumber);
    }

    /**
     * Mappings for joysticks.
     */
    private static class Mappings {

        private static final int climberArmSolenoidStartExtendButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        private static final int climberArmSolenoidStartExtendButtonNumber = FV.BUTTON.STAND_OF_JOYSTICK.BOTTOM_LEFT;
        //
        private static final int shooterSolenoidPushButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        private static final int shooterSolenoidPushButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.TRIGGER;
        //
        private static final int shooterMotorOnButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        private static final int shooterMotorOnButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.RIGHT;
        //
        private static final int shooterMotorOffButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        private static final int shooterMotorOffButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.LEFT;
        //
        private static final int driveSpeedToggleButtonJoystickNumber = FV.DRIVE_JOYSTICK;
        private static final int driveSpeedToggleButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.MIDDLE;
        //
        private static final int ladderControlAxisJoystickNumber = FV.SHOOTER_JOYSTICK;
        private static final int ladderControlAxisNumber = FV.AXIS.Y;
        //
        private static final int driveControlReverseButtonJoystickNumber = FV.DRIVE_JOYSTICK;
        private static final int driveControlReverseButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.BOTTOM;
        //
        private static final int frisbeeDumpButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        private static final int frisbeeDumpButtonNumber = FV.BUTTON.STAND_OF_JOYSTICK.RIGHT_TOP;
        //
        private static final int frisbeeUnDumpButtonJoystickNumber = FV.SHOOTER_JOYSTICK;
        private static final int frisbeeUnDumpButtonNumber = FV.BUTTON.STAND_OF_JOYSTICK.RIGHT_BOTTOM;
        //
        private static final int groundDriveFastTurnLeftButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.LEFT;
        private static final int groundDriveFastTurnLeftButtonJoystickNumber = FV.DRIVE_JOYSTICK;
        //
        private static final int groundDriveFastTurnRightButtonNumber = FV.BUTTON.TOP_OF_JOYSTICK.RIGHT;
        private static final int groundDriveFastTurnRightButtonJoystickNumber = FV.DRIVE_JOYSTICK;
        //
        private static final int climberWedgeSolenoidsOnButtonNumber = FV.BUTTON.STAND_OF_JOYSTICK.RIGHT_TOP;
        private static final int climberWedgeSolenoidsOnButtonJoystickNumber = FV.DRIVE_JOYSTICK;
        //
        private static final int climberWedgeSolenoidsOffButtonNumber = FV.BUTTON.STAND_OF_JOYSTICK.RIGHT_BOTTOM;
        private static final int climberWedgeSolenoidsOffButtonJoystickNumber = FV.DRIVE_JOYSTICK;
    }
}