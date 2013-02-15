package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
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
        climbSpeed *= 0.25;
        //The Following Code Won't Affect Anything If The Pressure Switches Are Not Attached/Not Pressed.
        if (climbSpeed != 0) {
            if (((VstM.Climber.climberState() == -1) != (climbSpeed < 0))
                    || ((VstM.Climber.climberState() == 1) != climbSpeed > 0)) {
                climbSpeed *= VstM.Climber.climberState();
            }
        }
        climber.runLadder(climbSpeed);
        RobotDebugger.push(climber);
    }
// Make this return true when this Command no longer needs to run execute()

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        climber.stop();
        RobotDebugger.push(climber);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
