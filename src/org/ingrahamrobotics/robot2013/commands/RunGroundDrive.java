package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.dashboardrelations.DashboardStore;
import org.ingrahamrobotics.robot2013.debugging.DebugInfo;
import org.ingrahamrobotics.robot2013.debugging.DebugInfoGroup;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.DebugOutput;
import org.ingrahamrobotics.robot2013.debugging.Debuggable;
import org.ingrahamrobotics.robot2013.debugging.infos.InfoState;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.vstj.VstJ;

/**
 * Ground Drive Command. This command takes input from the default joystick and
 * sets the drive motors accordingly. Using arcade drive. Also, it will take
 * input from a toggle button whether to go into high speed or low speed mode.
 * When in low speed mode the values retrieved from the controller are halved.
 */
public class RunGroundDrive extends CommandBase implements Debuggable {

    private boolean highSpeedLastPressed = false;
    private boolean reversedLastPressed = false;
    private boolean highSpeed = false;
    private boolean reversed = false;

    public RunGroundDrive() {
        requires(groundDrive);
    }

    protected void initialize() {
        groundDrive.stop();
        RobotDebugger.push(groundDrive);
        RobotDebugger.push(this);
    }

    protected void execute() {
        updateHighSpeed();
        updateReversed();
        //groundDrive.setSpeedMutliplier(highSpeed ? 1 : 0.7, reversed);
        groundDrive.setSpeedMutliplier(DashboardStore.getGroundDriveSpeedMultiplier(), reversed);
        groundDrive.driveWithDefaultController();
        RobotDebugger.push(groundDrive);
        RobotDebugger.push(this);
    }

    private void updateHighSpeed() {
        if (VstJ.getDriveSpeedToggleButton().get() != highSpeedLastPressed) {
            if (!highSpeedLastPressed) {
                highSpeed = !highSpeed;
            }
            highSpeedLastPressed = !highSpeedLastPressed;
        }
    }

    private void updateReversed() {
        if (VstJ.getDriveControlReverseButton().get() != reversedLastPressed) {
            if (!reversedLastPressed) {
                reversed = !reversed;
            }
            reversedLastPressed = !reversedLastPressed;
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        groundDrive.stop();
    }

    public DebugOutput getStatus() {
        return new DebugInfoGroup(new DebugInfo[]{
            new InfoState("GroundDrive:Command:Speed", highSpeed ? "High" : "Low", DebugLevel.HIGHEST),
            new InfoState("GroundDrive:Command:Reversed", reversed ? "Yes" : "No", DebugLevel.HIGHEST)
        });
    }
}
