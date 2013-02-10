package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.ReadPressureSwitch;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

public class PressureSwitch extends Subsystem {

    DigitalInput pSwitch = new DigitalInput(VstM.Digital.PRESSURE_SWITCH);

    public void initDefaultCommand() {
        setDefaultCommand(new ReadPressureSwitch());
    }

    public void checkPressure() {
        // Switch is normally closed, so invert the reading
        VstP.setAtPressure(!pSwitch.get());
        this.dashboard();
    }

    private void dashboard() {
        if (VstM.Debug.DASHBOARD) {
            SmartDashboard.putBoolean("At Pressure", VstP.atPressure());
        }
    }
}
