package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 * This Command Constantly Updates The Pressure Switch, and sets variables in
 * VstP accordingly.
 */
public class ReadPressureSwitch extends CommandBase {

    /**
     * Default Constructor.
     */
    public ReadPressureSwitch() {
        requires(pressureSwitch);
    }

    protected void initialize() {
    }

    protected void execute() {
        // Tell pressureSwitch to check pressure.
        pressureSwitch.checkPressure();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        VstP.setAtPressure(true);
    }
}
