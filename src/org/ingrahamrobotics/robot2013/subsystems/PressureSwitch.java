package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.commands.ReadPressureSwitch;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.variablestores.VstM;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstPressure;

/**
 * SubSystem for reading the PressureSwitch and outputting to VstP.
 *
 * This is the pressure switch in the compressor system.
 */
public class PressureSwitch extends Subsystem {

    /**
     * This is a Digital Pressure Switch.
     */
    private final DigitalInput pSwitch = new DigitalInput(VstM.DIGITAL_IO.PRESSURE_SWITCH);

    public PressureSwitch() {
        System.out.println("SubSystem Created: PressureSwitch");
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ReadPressureSwitch());
    }

    /**
     * This function checks with the Pressure Switch configured in VstM.Digital,
     * and sets VstP.atPressure(). This does auto-push the class.
     */
    public void checkPressure() {
        // Switch is normally closed, so invert the reading
        boolean newVal = !pSwitch.get();
        if (newVal != DVstPressure.atPressure()) {
            DVstPressure.setAtPressure(newVal);
            outputStatus();
        }
    }

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.HIGHEST, "PressureSwitch:AtPressure", DVstPressure.atPressure());
    }
}
