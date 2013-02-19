package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author daboross
 */
public class RunFrisbeeDumperSolenoid extends CommandBase {

    private boolean done;

    public RunFrisbeeDumperSolenoid() {
        requires(frisbeeDumperSolenoid);
    }

    protected void initialize() {
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
