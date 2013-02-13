package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private Joystick xbox;

    public OI() {
        xbox = new Joystick(VstM.Joysticks.Xbox.PORT);
    }

    public Joystick getDriveJoystick() {
        return xbox;
    }
}