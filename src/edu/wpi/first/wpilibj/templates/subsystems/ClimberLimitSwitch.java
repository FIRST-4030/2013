package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.ReadLimitSwitch;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 */
public class ClimberLimitSwitch extends Subsystem implements Debuggable {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private DigitalInput lowerLimit = new DigitalInput(VstM.Relays.LOWER_LIMIT_SWITCH);
    private DigitalInput upperLimit = new DigitalInput(VstM.Relays.UPPER_LIMIT_SWITCH);

    public void initDefaultCommand() {
        setDefaultCommand(new ReadLimitSwitch());
    }

    public boolean readUpper() {
        return upperLimit.get();
    }

    public boolean readLower() {
        return lowerLimit.get();
    }

    public DebugInfo getStatus() {
        return new DebugInfo("ClimberLimitSwitch:Status", "Upper Limit " + (upperLimit.get() ? "is" : "is not") + " triggered, Lower Limit " + (lowerLimit.get() ? "is" : "is not")+" triggered");
    }
}