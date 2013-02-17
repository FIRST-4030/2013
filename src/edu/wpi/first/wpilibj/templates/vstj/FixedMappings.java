package edu.wpi.first.wpilibj.templates.vstj;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class FixedMappings {

    private static Joystick[] joySticks;

    protected static void joyStickInit() {
        joySticks = new Joystick[4];
        for (int i = 0; i < joySticks.length; i++) {
            joySticks[i] = new Joystick(i);
        }
    }

    protected static Joystick getDefaultJoyStick() {
        if (joySticks == null) {
            joyStickInit();
        }
        return joySticks[VstJ.usingXBox ? VstJ.xBoxJoystickPort : VstJ.logitechJoystickPort];
    }

    protected static int getClimberAxisNumber() {
        return VstJ.usingXBox ? Xbox.climberAxisNumber : RegularJoyStick.climberAxisNumber;
    }

    protected static int getShooterSolenoidPushButtonNumber() {
        return VstJ.usingXBox ? Xbox.solenoidButtonNumber : RegularJoyStick.solenoidButtonNumber;

    }

    protected static int getShooterMotorSpeedUpButtonNumber() {
        return VstJ.usingXBox ? Xbox.shooterMotorSpeedUpButtonNumber : RegularJoyStick.shooterMotorSpeedUpButtonNumber;
    }

    protected static int getShooterMotorSpeedDownButtonNumber() {
        return VstJ.usingXBox ? Xbox.shooterMotorSpeedDownButtonNumber : RegularJoyStick.shooterMotorSpeedDownButtonNumber;
    }

    protected static int getDriveSpeedToggleButtonNumber() {
        return VstJ.usingXBox ? Xbox.driveSpeedToggleButton : RegularJoyStick.driveSpeedToggleButton;
    }

    protected static int getClimberArmToggleButtonNumber() {
        return VstJ.usingXBox ? Xbox.climberArmToggle : RegularJoyStick.climberArmToggle;
    }

    /**
     * This is the XBox controller.
     */
    protected static class Xbox {

        protected static final int climberAxisNumber = FixedVars.Xbox.AXIS.TRIGGERS;
        protected static final int solenoidButtonNumber = FixedVars.Xbox.BUTTON.LEFT_TRIGGER;
        protected static final int shooterMotorSpeedUpButtonNumber = FixedVars.Xbox.BUTTON.B;
        protected static final int shooterMotorSpeedDownButtonNumber = FixedVars.Xbox.BUTTON.A;
        protected static final int driveSpeedToggleButton = FixedVars.Xbox.BUTTON.LEFT_CIRCLE_PUSH;
        protected static final int climberArmToggle = FixedVars.Xbox.BUTTON.START;
    }

    /**
     * This is the regular First joystick, then original one.
     */
    private static class RegularJoyStick {

        protected static final int climberAxisNumber = -20;
        protected static final int solenoidButtonNumber = FixedVars.RegularJoyStick.BUTTON.TOP_OF_JOYSTICK.TRIGGER;
        protected static final int shooterMotorSpeedUpButtonNumber = FixedVars.RegularJoyStick.BUTTON.TOP_OF_JOYSTICK.RIGHT;
        protected static final int shooterMotorSpeedDownButtonNumber = FixedVars.RegularJoyStick.BUTTON.TOP_OF_JOYSTICK.LEFT;
        protected static final int driveSpeedToggleButton = FixedVars.RegularJoyStick.BUTTON.TOP_OF_JOYSTICK.MIDDLE;
        protected static final int climberArmToggle = FixedVars.RegularJoyStick.BUTTON.STAND_OF_JOYSTICK.LEFT_TOP;
    }
}
