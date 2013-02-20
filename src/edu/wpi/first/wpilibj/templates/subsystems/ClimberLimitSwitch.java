package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This is a sub system that reads 2 different Digital Inputs which are the top
 * and bottom limit of the climber. These Digital Inputs are currently not on
 * the Robot.
 */
public class ClimberLimitSwitch extends Subsystem implements Debuggable {

    public ClimberLimitSwitch(){
        System.out.println("ClimberLimitSwitch: Created");
    }
    private DigitalInput lowerLimit = new DigitalInput(VstM.DIGITAL_IO.CLIMBER_LOWER_LIMIT_SWITCH);
    private DigitalInput upperLimit = new DigitalInput(VstM.DIGITAL_IO.CLIMBER_UPPER_LIMIT_SWITCH);
    private DigitalInput deploySwitch = new DigitalInput(VstM.DIGITAL_IO.CLIMBER_DEPLOY_LIMIT_SWITCH);

    public void initDefaultCommand() {
    }

    public boolean readUpper() {
        return upperLimit.get();
    }

    public boolean readLower() {
        return lowerLimit.get();
    }

    public boolean readDeploy() {
        return deploySwitch.get();
    }

    public DebugOutput getStatus() {
        DebugStatus[] infoList = new DebugStatus[3];
        infoList[0] = new DebugStatus("ClimberLimitSwitch:UpperLimit:Triggered", upperLimit.get(), DebugLevel.MID);
        infoList[1] = new DebugStatus("ClimberLimitSwitch:LowerLimit:Triggered", lowerLimit.get(), DebugLevel.MID);
        infoList[2] = new DebugStatus("ClimberLimitSwitch:DeploySwitch:Triggered", lowerLimit.get(), DebugLevel.MID);
        DebugInfoGroup infoGroup = new DebugInfoGroup(infoList);
        return infoGroup;
    }
}
