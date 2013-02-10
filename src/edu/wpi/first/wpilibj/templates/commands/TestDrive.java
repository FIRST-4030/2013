package edu.wpi.first.wpilibj.templates.commands;

public class TestDrive extends CommandBase {

    public TestDrive() {
        requires(testMotors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        testMotors.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        testMotors.drive(oi.getDriveJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        testMotors.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
