/*
 * Author: Dabo Ross
 * Website: www.daboross.net
 * Email: daboross@daboross.net
 */
package org.ingrahamrobotics.robot2013.commands.joystickswitching;

import org.ingrahamrobotics.robot2013.commands.CommandBase;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstGroundDrive;
import org.ingrahamrobotics.robot2013.vstj.FV;
import org.ingrahamrobotics.robot2013.vstj.VstJ;

/**
 *
 * @author daboross
 */
public class FirstJoystickButtonPressed extends CommandBase {

    private boolean isFinished;

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        if (VstJ.getSwitchToSecondDriveModeButton().get()) {
            DVstGroundDrive.setTankDrive(true);
            FV.CHANGING.setCurrentArcadeDriveJoystick(FV.FIRST_POSSIBLE_ARCADE_DRIVE_JOYSTICK);
        } else {
            DVstGroundDrive.setTankDrive(false);
            FV.CHANGING.setCurrentArcadeDriveJoystick(FV.FIRST_POSSIBLE_ARCADE_DRIVE_JOYSTICK);
        }
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
