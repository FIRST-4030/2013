package org.ingrahamrobotics.robot2013.commands.grounddrive;

import org.ingrahamrobotics.robot2013.commands.CommandBase;
import org.ingrahamrobotics.robot2013.dashboardrelations.DashboardStore;
import org.ingrahamrobotics.robot2013.debugging.DebugInfo;
import org.ingrahamrobotics.robot2013.debugging.DebugInfoGroup;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.DebugOutput;
import org.ingrahamrobotics.robot2013.debugging.Debuggable;
import org.ingrahamrobotics.robot2013.debugging.infos.InfoState;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstGroundDrive;

/**
 * Ground Drive Command. This command takes input from the default joystick and
 * sets the drive motors accordingly. Using arcade drive. Also, it will take
 * input from a toggle button whether to go into high speed or low speed mode.
 * When in low speed mode the values retrieved from the controller are halved.
 */
public class RunGroundDrive extends CommandBase implements Debuggable {

    private String highSpeedState = "Azdef";

    public RunGroundDrive() {
        requires(groundDrive);
    }

    protected void initialize() {
        groundDrive.stop();
        RobotDebugger.push(groundDrive);
        RobotDebugger.push(this);
    }

    protected void execute() {
        double mul = DashboardStore.getGroundDriveSpeedMultiplier();
        highSpeedState = String.valueOf(mul);
        groundDrive.setSpeedMutliplier(mul, DVstGroundDrive.isReversed());
        if (DVstGroundDrive.isTankDrive()) {
            groundDrive.tankDriveRefresh();
        } else {
            groundDrive.arcadeDriveRefresh();
        }
        RobotDebugger.push(groundDrive);
        RobotDebugger.push(this);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        groundDrive.stop();
    }

    public DebugOutput getStatus() {
        return new DebugInfoGroup(new DebugInfo[]{
            new InfoState("GroundDrive:Command:Speed", highSpeedState, DebugLevel.HIGHEST),
            new InfoState("GroundDrive:Command:Reversed", DVstGroundDrive.isReversed() ? "Yes" : "No", DebugLevel.HIGHEST)
        });
    }
}
