package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstC;

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
        DVstC.LimitSwitches.setDeploy(climberLimitSwitch.readDeploy());
        DVstC.LimitSwitches.setUpper(climberLimitSwitch.readUpper());
        DVstC.LimitSwitches.setLower(climberLimitSwitch.readLower());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        System.out.println("WARNING: ReadLimitSwitches Ended!");
    }
}
