package edu.wpi.first.wpilibj.templates.helpers.solenoid;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author daboross
 */
public class SolenoidPair {

    private Solenoid extendingSolenoid;
    private Solenoid retractingSolenoid;
    private boolean extending = false;
    private boolean isStateSet = false;

    public SolenoidPair(int extendingSolenoidPort, int retractingSolenoidPort) {
        extendingSolenoid = new Solenoid(extendingSolenoidPort);
        retractingSolenoid = new Solenoid(retractingSolenoidPort);
    }

    public void extend() {
        retractingSolenoid.set(false);
        extendingSolenoid.set(true);
        extending = true;
        isStateSet = true;
    }

    public void retract() {
        extendingSolenoid.set(false);
        retractingSolenoid.set(true);
        extending = false;
        isStateSet = true;
    }

    public boolean isExtending() {
        return extending;
    }

    public String getState() {
        if (isStateSet) {
            return extending ? "Extending" : "Retracting";
        } else {
            return "Not Set";
        }
    }
}
