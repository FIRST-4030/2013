package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 *
 * @author daboross
 */
public class SmartdashboardJoystick extends CommandBase {

    private SendableChooser which;
    private SendableChooser xboxPort;
    private SendableChooser logitechPort;

    protected void initialize() {
        which = new SendableChooser();
        if (VstJ.usingXBox) {
            which.addDefault("XBox", Boolean.TRUE);
            which.addObject("Logitech", Boolean.FALSE);
        } else {
            which.addDefault("Logitech", Boolean.FALSE);
            which.addObject("XBox", Boolean.TRUE);
        }
        SmartDashboard.putData("WhichController", which);
        xboxPort = new SendableChooser();
        for (int i = 1; i < 5; i++) {
            if (i == VstJ.xBoxJoystickPort) {
                xboxPort.addDefault("XBox is Number " + i, Integer.valueOf(i));
            } else {
                xboxPort.addObject("XBox is Number " + i, Integer.valueOf(i));
            }
        }
        SmartDashboard.putData("xboxPort", xboxPort);
        logitechPort = new SendableChooser();
        for (int i = 1; i < 5; i++) {
            if (i == VstJ.xBoxJoystickPort) {
                logitechPort.addDefault("Logitech Controller is Number " + i, Integer.valueOf(i));
            } else {
                logitechPort.addObject("Logitech Controller is Number " + i, Integer.valueOf(i));
            }
        }
        SmartDashboard.putData("logitechPort", logitechPort);
    }

    protected void execute() {
        VstJ.usingXBox = which.getSelected() == Boolean.TRUE;
        VstJ.xBoxJoystickPort = ((Integer) xboxPort.getSelected()).intValue();
        VstJ.logitechJoystickPort = ((Integer) logitechPort.getSelected()).intValue();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
