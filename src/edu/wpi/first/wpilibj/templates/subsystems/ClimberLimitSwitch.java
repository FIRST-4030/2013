package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.ReadLimitSwitch;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This is a sub system that reads 2 different Digital Inputs which are the top
 * and bottom limit of the climber.
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

    public DebugOutput getStatus() {
        DebugStatus[] infoList = new DebugStatus[2];
        infoList[0] = new DebugStatus("ClimberLimitSwitch:UpperLimit:Triggered", upperLimit.get());
        infoList[1] = new DebugStatus("ClimberLimitSwitch:LowerLimit:Triggered", lowerLimit.get());
        DebugInfoGroup infoGroup = new DebugInfoGroup(infoList);
        return infoGroup;
    }
}
