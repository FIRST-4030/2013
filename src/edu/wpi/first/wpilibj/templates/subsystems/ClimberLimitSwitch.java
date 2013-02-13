/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.ReadLimitSwitch;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author Robotics
 */
public class ClimberLimitSwitch extends Subsystem {
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
}
