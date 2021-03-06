package org.ingrahamrobotics.robot2013.commands.grounddrive;

import org.ingrahamrobotics.robot2013.commands.CommandBase;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstGroundDrive;

/**
 *
 */
public class ReverseDriveControl extends CommandBase {

    private boolean isFinished;

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        DVstGroundDrive.setReversed(!DVstGroundDrive.isReversed());
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
