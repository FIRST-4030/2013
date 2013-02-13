package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author Robotics
 */
public class RunClimber extends CommandBase {

    public RunClimber() {
        requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        climber.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double climbSpeed = OI.getDriveJoystick().getRawAxis(VstM.Joysticks.Xbox.TRIGGERS);
<<<<<<< HEAD
        if (!VstM.Climber.isRetracting) {
            climbSpeed *= -1;
=======
        if (climbSpeed < 0 && climber.isAtLowerLimit()) {
            climber.runLadder(climbSpeed);
        } else if (climbSpeed > 0 && climber.isAtUpperLimit()) {
            climber.runLadder(climbSpeed);
        } else {
            climber.stop();
>>>>>>> cb7ed8d5a3fce72cb6ce165f7d0d223e8db5f646
        }
        climber.runLadder(climbSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        climber.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
