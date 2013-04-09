package org.ingrahamrobotics.robot2013.variablestores.dynamic;

/**
 * Dynamic Pneumatics Variable Store. This stores whether the System is at
 * pressure.
 */
public class DVstPressure {

    private static boolean atPressure = false;

    /**
     * This function returns whether or not the PressureSwitch is at Pressure.
     *
     * @return A stored value that is set with setAtPressure().
     */
    public static boolean atPressure() {
        return atPressure;
    }

    /**
     * This sets the value to be returned by atPressure().
     *
     * @param atPressureSet Whether or not the Pressure Switch is at pressure.
     */
    public static void setAtPressure(final boolean atPressureSet) {
        atPressure = atPressureSet;
    }
}
