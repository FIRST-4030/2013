package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 *
 * @author daboross
 */
public class XBoxDashboard extends CommandBase {

    private SendableChooser xbox;

    protected void initialize() {
        xbox = new SendableChooser();
        if (VstJ.USING_XBOX) {
            xbox.addDefault("XBox", Boolean.TRUE);
            xbox.addObject("Logitech", Boolean.FALSE);
        } else {
            xbox.addDefault("Logitech", Boolean.FALSE);
            xbox.addObject("XBox", Boolean.TRUE);
        }
        SmartDashboard.putData("Controller Mapping", xbox);
    }

    protected void execute() {
        VstJ.USING_XBOX = xbox.getSelected() == Boolean.TRUE;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
