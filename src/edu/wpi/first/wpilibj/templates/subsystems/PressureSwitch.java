package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.ReadPressureSwitch;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 * SubSystem for reading the PressureSwitch and outputting to VstP.
 *
 * This is the pressure switch in the compressor system.
 */
public class PressureSwitch extends Subsystem implements Debuggable {

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
        RobotDebugger.push(this);
    }

    public DebugOutput getStatus() {
        return new DebugStatus("PressureSwitch:AtPressure", VstP.atPressure() ? "yes" : "no", DebugLevel.HIGH);
    }
}
