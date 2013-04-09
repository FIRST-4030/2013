package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstPressure;

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
        pressureSwitch.checkPressure();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        DVstPressure.setAtPressure(true);
    }
}
