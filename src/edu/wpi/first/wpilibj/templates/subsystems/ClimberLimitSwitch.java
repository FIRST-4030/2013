package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.ReadLimitSwitches;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This is a sub system that reads 3 different Digital limit switch Inputs which
 * are the top, bottom and middle of the climber.
 */
public class ClimberLimitSwitch extends Subsystem implements Debuggable {

    public ClimberLimitSwitch() {
        System.out.println("SubSystem Created: ClimberLimitSwitch");
    }
    private final DigitalInput lowerSwitch = new DigitalInput(VstM.DIGITAL_IO.CLIMBER_LOWER_LIMIT_SWITCH);
    private final DigitalInput upperSwitch = new DigitalInput(VstM.DIGITAL_IO.CLIMBER_UPPER_LIMIT_SWITCH);
    private final DigitalInput deploySwitch = new DigitalInput(VstM.DIGITAL_IO.CLIMBER_DEPLOY_LIMIT_SWITCH);
    private boolean upperLast;
    private boolean lowerLast;
    private boolean deployLast;

    public void initDefaultCommand() {
        setDefaultCommand(new ReadLimitSwitches());
    }

    public boolean readUpper() {
        final boolean value = upperSwitch.get();
        upperLast = value;
        return value;
    }

    public boolean readLower() {
        final boolean value = lowerSwitch.get();
        lowerLast = value;
        return value;
    }

    public boolean readDeploy() {
        final boolean value = deploySwitch.get();
        deployLast = value;
        return value;
    }

    public DebugOutput getStatus() {
        DebugStatus[] infoList = new DebugStatus[3];
        infoList[0] = new DebugStatus("ClimberLimitSwitch:UpperSwitch", upperLast, DebugLevel.HIGH);
        infoList[1] = new DebugStatus("ClimberLimitSwitch:LowerSwitch", lowerLast, DebugLevel.HIGH);
        infoList[2] = new DebugStatus("ClimberLimitSwitch:DeploySwitch", deployLast, DebugLevel.HIGH);
        DebugInfoGroup infoGroup = new DebugInfoGroup(infoList);
        return infoGroup;
    }
}
