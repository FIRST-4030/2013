package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.ReadPressureSwitch;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 * SubSystem for reading the PressureSwitch and outputting to VstP.
 */
public class PressureSwitch extends Subsystem {

    /**
     * This is a Digital Pressure Switch.
     */
    DigitalInput pSwitch = new DigitalInput(VstM.Digital.PRESSURE_SWITCH);

    public void initDefaultCommand() {
        setDefaultCommand(new ReadPressureSwitch());
    }

    /**
     * This function checks with the Pressure Switch configured in VstM.Digital,
     * and sets VstP.atPressure().
     */
    public void checkPressure() {
        // Switch is normally closed, so invert the reading
        VstP.setAtPressure(!pSwitch.get());
        this.dashboard();
    }

    /**
     * This function checks if VstM.Debug.DASHBOARD, and if true, puts the
     * current reading to the Smart Dashboard.
     */
    private void dashboard() {
        if (VstM.Debug.DASHBOARD) {
            SmartDashboard.putBoolean("At Pressure", VstP.atPressure());
        }
    }
}
