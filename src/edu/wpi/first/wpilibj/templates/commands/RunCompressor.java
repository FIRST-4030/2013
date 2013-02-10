package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.VstP;

public class RunCompressor extends CommandBase {

    public RunCompressor() {
        requires(compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        compressor.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!VstP.atPressure()) {
            compressor.start();
        } else {
            compressor.stop();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        compressor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
