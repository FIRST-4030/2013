package edu.wpi.first.wpilibj.templates.dashboardrelations;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author daboross
 */
public final class BooleanDashObject {

    private SendableChooser sendable;
    private String name;
    private String trueName;
    private String falseName;
    private boolean defaultValue;

    public BooleanDashObject(String name, String trueName, String falseName, boolean defaultValue) {
        this.name = name;
        this.trueName = trueName;
        this.falseName = falseName;
        this.defaultValue = defaultValue;
        reCreate();
    }

    public boolean getValue() {
        return sendable.getSelected() == Boolean.TRUE;
    }

    public void reCreate() {
        sendable = new SendableChooser();
        if (defaultValue) {
            sendable.addDefault(trueName, Boolean.TRUE);
            sendable.addObject(falseName, Boolean.FALSE);
        } else {
            sendable.addDefault(falseName, Boolean.FALSE);
            sendable.addObject(trueName, Boolean.TRUE);
        }
        SmartDashboard.putData(name, sendable);
    }
}