package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.ClimberStore;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * Ground Drive Command. This command takes input from the default joystick and
 * sets the drive motors accordingly. Using arcade drive. Also, it will take
 * input from a toggle button whether to go into high speed or low speed mode.
 * When in low speed mode the values retrieved from the controller are halved.
 */
public class GroundDriveCommand extends CommandBase implements Debuggable {

    private boolean highSpeed = false;
    private boolean reversed = false;
    private boolean isDone = false;

    public GroundDriveCommand() {
        requires(groundDrive);
    }

    // Called just before this Command runs the first time.
    protected void initialize() {
        groundDrive.stop();
        RobotDebugger.push(groundDrive);
        RobotDebugger.push(this);
    }

    // Called repeatedly when this Command is scheduled to run.
    protected void execute() {
        if (DashboardStore.getIsClimberEnabled()) {
            if (ClimberStore.climberFirstDown) {
                groundDrive.driveWithRaw(-0.5, 0);
            } else {
                groundDrive.stop();
            }
        } else {
            updateHighSpeed();
            updateReversed();
            groundDrive.setSpeedMutliplier(highSpeed ? 1 : 0.7, reversed);
            groundDrive.driveWithDefaultController();
        }
        RobotDebugger.push(groundDrive);
        RobotDebugger.push(this);
    }

    // Make this return true when this Command no longer needs to run execute().
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
        groundDrive.stop();
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
        end();
    }

    public DebugOutput getStatus() {
        return new InfoState("GroundDrive:Speed", highSpeed ? "High" : "Low", DebugLevel.LOW);
    }
    private boolean highSpeedLastPressed = false;
    private boolean reversedLastPressed = false;

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
}