package edu.wpi.first.wpilibj.templates.dashboardrelations;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author daboross
 */
public final class IntegerDashObject {

    private SendableChooser sendable;
    private String name;
    private String[] options;
    private int defaultValue;

    public IntegerDashObject(String name, String[] options, int defaultValue) {
        if (defaultValue < 0 || defaultValue >= options.length) {
            throw new IllegalArgumentException("IntegerDashObject Constructor: defaultValue is more then options length or less then 0.");
        }
        this.name = name;
        this.options = options;
        this.defaultValue = defaultValue;
        reCreate();
    }

    public void reCreate() {
        sendable = new SendableChooser();
        for (int i = 0; i < options.length; i++) {
            String current = options[i];
            if (i == defaultValue) {
                sendable.addDefault(current, Integer.valueOf(i));
            } else {
                sendable.addObject(current, Integer.valueOf(i));
            }
            SmartDashboard.putData(name, sendable);
        }
    }
}
