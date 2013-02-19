package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;

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
        if (DashboardStore.getIsClimberEnabled()) {
        }
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
