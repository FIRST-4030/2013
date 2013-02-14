package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
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
        double climbSpeed = oi.getDriveJoystick().getRawAxis(VstM.Joysticks.Xbox.TRIGGERS);

        /*
         * Older Code, I Didn't Delete.
         if (!VstM.Climber.isRetracting) {
         climbSpeed *= -1; 
         * //Won't This Just Reverse The Direction No Matter Which Way It Was Going In The First Place? 
         * //Like if It Started Out Positive It Would Become Negative, and if it started out negative it would become positive.
         }
         
        if (climbSpeed != 0) {
            if (((VstM.Climber.climberState() == -1) != (climbSpeed < 0))
                    || ((VstM.Climber.climberState() == 1) != climbSpeed > 0)) {
                climbSpeed *= VstM.Climber.climberState();
            }
        }*/
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
