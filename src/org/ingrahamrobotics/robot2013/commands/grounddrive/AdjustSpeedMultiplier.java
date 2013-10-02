package org.ingrahamrobotics.robot2013.commands.grounddrive;

import org.ingrahamrobotics.robot2013.commands.CommandBase;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstGroundDrive;

/**
 *
 */
public class AdjustSpeedMultiplier extends CommandBase {

    private boolean lastStateHighSpeed;
    private boolean executed;

    public AdjustSpeedMultiplier() {
        lastStateHighSpeed = true;
        DVstGroundDrive.setSpeedMultiplier(1.0);
        executed = false;
    }

    protected void initialize() {
        executed = false;
    }

    protected void execute() {
        lastStateHighSpeed = !lastStateHighSpeed;
        DVstGroundDrive.setSpeedMultiplier(lastStateHighSpeed ? 1.0 : 0.5);
    }

    protected boolean isFinished() {
        return executed;

    }

    protected void end() {
    }
}
