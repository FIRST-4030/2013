package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.ReadPressureSwitch;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

public class PressureSwitch extends Subsystem {

    DigitalInput pSwitch = new DigitalInput(VstM.digital.PRESSURE_SWITCH);

    public void initDefaultCommand() {
        setDefaultCommand(new ReadPressureSwitch());
    }

    public void checkPressure() {
        // Switch is normally closed -- opens when at pressure
        boolean atPressure = !pSwitch.get();
        SmartDashboard.putBoolean("At Pressure", atPressure);
        VstP.setAtPressure(atPressure);
    }
}
