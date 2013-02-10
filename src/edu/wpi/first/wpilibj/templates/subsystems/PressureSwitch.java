/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.ReadPressureSwitch;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 *
 * @author Ingyram
 */
public class PressureSwitch extends Subsystem {

    DigitalInput pSwitch = new DigitalInput(1);
    
    public void initDefaultCommand() {
        setDefaultCommand(new ReadPressureSwitch());
    }
    
    public void checkPressure() {
        // Switch is normally closed -- opens when at pressure
        boolean atPressure = !pSwitch.get();
        SmartDashboard.putBoolean("P2", pSwitch.get());
        SmartDashboard.putBoolean("At Pressure", atPressure);
        VstP.setAtPressure(atPressure);
    }
}
