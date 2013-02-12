package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 * Ground Drive Command.
 */
public class GroundDriveCommand extends CommandBase {

    private boolean isDone = false;

    public GroundDriveCommand() {
        requires(groundDrive);
    }

    // Called just before this Command runs the first time.
    protected void initialize() {
        groundDrive.driveWithXBox();
        RobotDebugger.push(groundDrive);
    }

    // Called repeatedly when this Command is scheduled to run.
    protected void execute() {
        isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute().
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}