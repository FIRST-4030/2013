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

    public SolenoidPair(int extendingSolenoidPort, int retractingSolenoidPort, boolean extendingFirst) {
        extendingSolenoid = new Solenoid(extendingSolenoidPort);
        retractingSolenoid = new Solenoid(retractingSolenoidPort);
        extendingSolenoid.set(extendingFirst);
        retractingSolenoid.set(!extendingFirst);
        extending = extendingFirst;
    }

    public void extend() {
        retractingSolenoid.set(false);
        extendingSolenoid.set(true);
        extending = true;
    }

    public void retract() {
        extendingSolenoid.set(false);
        retractingSolenoid.set(true);
        extending = false;
    }

    public boolean isExtending() {
        return extending;
    }

    public String getState() {
        return extending ? "Extending" : "Retracting";
    }
}
