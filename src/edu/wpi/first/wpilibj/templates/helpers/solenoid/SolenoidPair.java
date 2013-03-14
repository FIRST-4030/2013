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

    /**
     * Extends this SolenoidPair. (Sets the extendingSolenoid to true, and the
     * retractingSolenoid to false).
     *
     * @return Whether or not the Solenoid's state was changed. (basically
     * returns whether or not the solenoid was retracting before.)
     */
    public boolean extend() {
        retractingSolenoid.set(false);
        extendingSolenoid.set(true);
        boolean lastExtending = extending;
        extending = true;
        // I would say 
        // return lastExtending != true;
        // But that is the same thing
        return !lastExtending;
    }

    /**
     * Extends this SolenoidPair. (Sets the extendingSolenoid to false, and the
     * retractingSolenoid to true).
     *
     * @return Whether or not the Solenoid's state was changed. (basically
     * returns whether or not the solenoid was extending before.)
     */
    public boolean retract() {
        extendingSolenoid.set(false);
        retractingSolenoid.set(true);
        boolean lastExtending = extending;
        extending = false;
        // I would say 
        // return lastExtending != false;
        // But this does the same thing
        return lastExtending;
    }

    public boolean isExtending() {
        return extending;
    }

    public String getState() {
        return extending ? "Extending" : "Retracting";
    }
}
