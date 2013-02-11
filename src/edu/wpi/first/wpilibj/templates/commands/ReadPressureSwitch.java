package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 * This Command Constantly Updates The Pressure Switch.
 */
public class ReadPressureSwitch extends CommandBase {

    /**
     * Default Constructor.
     */
    public ReadPressureSwitch() {
        requires(pressureSwitch);
    }

    // Called once before first execute
    protected void initialize() {
        //Why are you putting it at pressure here?
        VstP.setAtPressure(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // Tell pressureSwitch to check pressure.
        pressureSwitch.checkPressure();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        //Why are you putting it at pressure here?
        VstP.setAtPressure(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
