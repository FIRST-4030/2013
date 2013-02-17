package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * Ground Drive Command. This command takes input from the default joystick and
 * sets the drive motors accordingly. Using arcade drive. Also, it will take
 * input from a toggle button whether to go into high speed or low speed mode.
 * When in low speed mode the values retrieved from the controller are halved.
 */
public class GroundDriveCommand extends CommandBase implements Debuggable {

    private boolean highSpeed = false;
    private boolean isDone = false;

    public GroundDriveCommand() {
        requires(groundDrive);
    }

    // Called just before this Command runs the first time.
    protected void initialize() {
        groundDrive.stop();
        RobotDebugger.push(groundDrive);
    }

    // Called repeatedly when this Command is scheduled to run.
    protected void execute() {
        updateHighSpeed();
        groundDrive.setSpeedMutliplier(highSpeed ? 1 : 0.5);
        groundDrive.driveWithDefaultController();
        RobotDebugger.push(groundDrive);
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
        return new DebugStatus("GroundDrive:Speed", highSpeed ? "High" : "Low");
    }
    private boolean lastPressed;

    private void updateHighSpeed() {
        if (VstJ.getDriveSpeedToggleButtonValue() != lastPressed) {
            if (lastPressed) {
                highSpeed = !highSpeed;
            }
            lastPressed = !lastPressed;
        }
    }
}