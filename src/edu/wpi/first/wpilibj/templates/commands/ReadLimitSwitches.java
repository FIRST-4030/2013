package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;

/**
 *
 * @author daboross
 */
public class ReadLimitSwitches extends CommandBase {

    public ReadLimitSwitches() {
        requires(climberLimitSwitch);
    }

    protected void initialize() {
    }

    protected void execute() {
        DVstClimber.LimitSwitches.setDeploy(climberLimitSwitch.readDeploy());
        DVstClimber.LimitSwitches.setUpper(climberLimitSwitch.readUpper());
        DVstClimber.LimitSwitches.setLower(climberLimitSwitch.readLower());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        System.out.println("WARNING: ReadLimitSwitches Ended!");
    }
}
