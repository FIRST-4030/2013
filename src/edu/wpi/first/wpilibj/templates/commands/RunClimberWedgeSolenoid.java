package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author daboross
 */
public class RunClimberWedgeSolenoid extends CommandBase {

    public RunClimberWedgeSolenoid() {
        requires(climberWedgeSolenoid);
    }

    protected void initialize() {
        climberWedgeSolenoid.stayPut();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}
