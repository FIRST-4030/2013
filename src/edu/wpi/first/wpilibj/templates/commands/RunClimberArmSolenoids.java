package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.DashboardStore;

/**
 *
 * @author daboross
 */
public class RunClimberArmSolenoids extends CommandBase {

    protected RunClimberArmSolenoids() {
        DashboardStore.initClimber();
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}
