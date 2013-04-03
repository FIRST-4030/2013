package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstLimitSwitches;

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
        DVstLimitSwitches.setDeploy(climberLimitSwitch.readDeploy());
        DVstLimitSwitches.setUpper(climberLimitSwitch.readUpper());
        DVstLimitSwitches.setLower(climberLimitSwitch.readLower());
        RobotDebugger.push(climberLimitSwitch);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
}
