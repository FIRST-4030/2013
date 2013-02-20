package edu.wpi.first.wpilibj.templates.variablestores.dynamic;

/**
 * Dynamic Pneumatics variable store. This stores whether the System is at pressure and
 * whether the compressor is running.
 */
public class DVstP {

    private static boolean atPressure = false;
    private static boolean compressorRunning = false;

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
     * @param atP Whether or not the Pressure Switch is at pressure.
     */
    public static void setAtPressure(boolean atP) {
        atPressure = atP;
    }

    /**
     * Returns whether or not the Compressor is running.
     *
     * @return A stored value that is set with setCompressorRunning().
     */
    public static boolean compressorRunning() {
        return compressorRunning;
    }

    /**
     * This sets the value to be returned by compressorRunning().
     *
     * @param running Whether or not the compressor is running.
     */
    public static void setCompressorRunning(boolean running) {
        compressorRunning = running;
    }
}
