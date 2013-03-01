package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author daboross
 */
public class AutoCommand extends CommandBase {
    
    private boolean isFinished = false;
    
    public AutoCommand() {
        requires(groundDrive);
        requires(shooterMotors);
        requires(shooterSolenoids);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return isFinished;
    }
    
    protected void end() {
    }
}