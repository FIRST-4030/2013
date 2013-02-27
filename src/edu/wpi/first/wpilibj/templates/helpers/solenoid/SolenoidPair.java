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

    public SolenoidPair(int retractingSolenoidPort, int extendingSolenoidPort) {
        retractingSolenoid = new Solenoid(retractingSolenoidPort);
        extendingSolenoid = new Solenoid(extendingSolenoidPort);
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
}
