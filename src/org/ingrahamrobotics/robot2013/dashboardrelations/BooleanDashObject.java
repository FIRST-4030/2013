package org.ingrahamrobotics.robot2013.dashboardrelations;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.ingrahamrobotics.robot2013.DisableNotifable;
import org.ingrahamrobotics.robot2013.RobotMain;

/**
 *
 */
public final class BooleanDashObject implements DisableNotifable {

    private final SendableChooser sendable;
    private final String name;

    public BooleanDashObject(String name, String trueName, String falseName, boolean defaultValue) {
        this.name = name;
        sendable = new SendableChooser();
        sendable.addDefault(defaultValue ? trueName : falseName, Boolean.valueOf(defaultValue));
        sendable.addObject(defaultValue ? falseName : trueName, Boolean.valueOf(!defaultValue));
        SmartDashboard.putData(name, sendable);
        RobotMain.addDisableNotifable(this);
    }

    public boolean getValue() {
        if (!(sendable.getSelected() instanceof Boolean)) {
            return false;
        }
        boolean value = ((Boolean) sendable.getSelected()).booleanValue();
        return value;
    }

    public void disable() {
        SmartDashboard.putData(name, sendable);
    }
}
