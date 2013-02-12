package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private static Joystick xbox = new Joystick(VstM.Joysticks.Xbox.PORT);

    public void init() {
    }

    public static Joystick getDriveJoystick() {
        return xbox;
    }
}
