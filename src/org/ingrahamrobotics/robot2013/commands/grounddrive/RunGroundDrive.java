package org.ingrahamrobotics.robot2013.commands.grounddrive;

import org.ingrahamrobotics.robot2013.commands.CommandBase;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstGroundDrive;

/**
 * Ground Drive Command. This command takes input from the default joystick and
 * sets the drive motors accordingly. Using arcade drive. Also, it will take
 * input from a toggle button whether to go into high speed or low speed mode.
 * When in low speed mode the values retrieved from the controller are halved.
 */
public class RunGroundDrive extends CommandBase {

    private String highSpeedState = "Default HighSpeedState";

    public RunGroundDrive() {
        requires(groundDrive);
    }

    protected void initialize() {
        groundDrive.stop();
        this.outputStatus();
        groundDrive.outputStatus();
    }

    protected void execute() {
        double speedMultiplier = DVstGroundDrive.getSpeedMultiplier();
        highSpeedState = String.valueOf(speedMultiplier);
        groundDrive.setSpeedMutliplier(speedMultiplier, DVstGroundDrive.isReversed());
        if (DVstGroundDrive.isTankDrive()) {
            groundDrive.tankDriveRefresh();
        } else {
            groundDrive.arcadeDriveRefresh();
        }
        this.outputStatus();
        groundDrive.outputStatus();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        groundDrive.stop();
    }

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.HIGHEST, "GroundDrive:Command:Speed", highSpeedState);
        RobotDebugger.output(DebugLevel.HIGHEST, "GroundDrive:Command:Reversed", DVstGroundDrive.isReversed());
    }
}
