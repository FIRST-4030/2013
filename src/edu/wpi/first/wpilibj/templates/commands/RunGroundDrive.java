package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

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
        if (DVstClimber.climberEnabled()) {
            groundDrive.driveWithRaw(-0.5, 0);
        } else {
            updateHighSpeed();
            updateReversed();
            groundDrive.setSpeedMutliplier(highSpeed ? 1 : 0.7, reversed);
            groundDrive.driveWithDefaultController();
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

    private void updateHighSpeed() {
        if (VstJ.getDriveSpeedToggleButtonValue() != highSpeedLastPressed) {
            if (!highSpeedLastPressed) {
                highSpeed = !highSpeed;
            }
            highSpeedLastPressed = !highSpeedLastPressed;
        }
    }

    private void updateReversed() {
        if (VstJ.getDriveControlReverseButtonValue() != reversedLastPressed) {
            if (!reversedLastPressed) {
                reversed = !reversed;
            }
            reversedLastPressed = !reversedLastPressed;
        }
    }

    public DebugOutput getStatus() {
        return new DebugInfoGroup(new DebugInfo[]{
            new InfoState("GroundDrive:Command:Speed", highSpeed ? "High" : "Low", DebugLevel.HIGHEST),
            new InfoState("GroundDrive:Command:Reversed", reversed ? "Yes" : "No", DebugLevel.HIGHEST)
        });

    }
}