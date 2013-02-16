package edu.wpi.first.wpilibj.templates.vstj;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class FixedMappings {

    private static Joystick defaultJoystick;

    protected static void joyStickInit() {
        defaultJoystick = new Joystick(VstJ.USING_XBOX ? FixedVars.Xbox.PORT : FixedVars.RegularJoyStick.PORT);
    }

    protected static Joystick getDefaultJoyStick() {
        if (defaultJoystick == null) {
            joyStickInit();
        }
        return defaultJoystick;
    }

    protected static int getClimberAxisNumber() {
        return VstJ.USING_XBOX ? Xbox.climberAxisNumber : RegularJoyStick.climberAxisNumber;
    }

    protected static int getShooterSolenoidPushButtonNumber() {
        return VstJ.USING_XBOX ? Xbox.solenoidButtonNumber : RegularJoyStick.solenoidButtonNumber;

    }

    protected static int getShooterMotorSpeedUpButtonNumber() {
        return VstJ.USING_XBOX ? Xbox.shooterMotorSpeedUpButtonNumber : RegularJoyStick.shooterMotorSpeedUpButtonNumber;
    }

    protected static int getShooterMotorSpeedDownButtonNumber() {
        return VstJ.USING_XBOX ? Xbox.shooterMotorSpeedDownButtonNumber : RegularJoyStick.shooterMotorSpeedDownButtonNumber;
    }

    protected static int getDriveSpeedToggleButtonNumber() {
        return VstJ.USING_XBOX ? Xbox.driveSpeedToggleButton : RegularJoyStick.driveSpeedToggleButton;
    }

    /**
     * This is the XBox controller.
     */
    protected static class Xbox {

        protected static final int climberAxisNumber = FixedVars.Xbox.TRIGGERS_AXIS;
        protected static final int solenoidButtonNumber = FixedVars.Xbox.X_BUTTON;
        protected static final int shooterMotorSpeedUpButtonNumber = FixedVars.Xbox.B_BUTTON;
        protected static final int shooterMotorSpeedDownButtonNumber = FixedVars.Xbox.A_BUTTON;
        protected static final int driveSpeedToggleButton = FixedVars.Xbox.Y_BUTTON;
    }

    /**
     * This is the regular First joystick, then original one.
     */
    private static class RegularJoyStick {

        protected static final int climberAxisNumber = -20;//TODO What is the climber axis number on the regular joy stick?
        protected static final int solenoidButtonNumber = FixedVars.RegularJoyStick.TRIGGER_BUTTON;
        protected static final int shooterMotorSpeedUpButtonNumber = FixedVars.RegularJoyStick.TOP_RIGHT_BUTTON;
        protected static final int shooterMotorSpeedDownButtonNumber = FixedVars.RegularJoyStick.TOP_LEFT_BUTTON;
        protected static final int driveSpeedToggleButton = FixedVars.RegularJoyStick.TOP_MIDDLE_BUTTON;
    }
}
