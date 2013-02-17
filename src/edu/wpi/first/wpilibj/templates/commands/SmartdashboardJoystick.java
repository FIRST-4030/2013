package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * This Command will get information from the smart dashboard and set which
 * controller/what port that controller is on accordingly.
 *
 * @author daboross
 */
public class SmartdashboardJoystick extends CommandBase {

    /**
     * Sendable Chooser for.
     */
    private SendableChooser which;
    /**
     * Sendable Chooser for what port the XBox controller is.
     */
    private SendableChooser xboxPort;
    /**
     * Sendable Chooser for what port the logitech controller is.
     */
    private SendableChooser logitechPort;

    /**
     * Default Constructor.
     */
    public SmartdashboardJoystick() {
    }

    protected void initialize() {
        which = new SendableChooser();
        //If Using XBox current, set the default option to XBox, otherwise set the default option to Logitech.
        if (VstJ.usingXBox) {
            which.addDefault("XBox", Boolean.TRUE);
            which.addObject("Logitech", Boolean.FALSE);
        } else {
            which.addDefault("Logitech", Boolean.FALSE);
            which.addObject("XBox", Boolean.TRUE);
        }
        SmartDashboard.putData("WhichController", which);
        //Put 4 ports on the XBox chooser, and if the port is the current XBox port, then make it the default.
        xboxPort = new SendableChooser();
        for (int i = 1; i < 5; i++) {
            if (i == VstJ.xBoxJoystickPort) {
                xboxPort.addDefault("XBox is Number " + i, Integer.valueOf(i));
            } else {
                xboxPort.addObject("XBox is Number " + i, Integer.valueOf(i));
            }
        }
        SmartDashboard.putData("xboxPort", xboxPort);
        //Put 4 ports on the Logitech chooser, and if the port is the current XBox port, then make it the default.
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
        // Set VstJ values retrieved from the SendableChoosers.
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
