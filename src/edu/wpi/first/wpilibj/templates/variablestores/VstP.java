package edu.wpi.first.wpilibj.templates.variablestores;

/**
 * Pneumatics variable store.
 */
public class VstP {

    static private boolean atPressure = false;
    static private boolean compressorRunning = false;

    /**
     * This function returns whether or not the PressureSwitch is at Pressure.
     *
     * @return A stored value that is set with setAtPressure().
     */
    static public boolean atPressure() {
        return atPressure;
    }

    /**
     * This sets the value to be returned by atPressure().
     *
     * @param atP Whether or not the Pressure Switch is at pressure.
     */
    static public void setAtPressure(boolean atP) {
        atPressure = atP;
    }

    /**
     * Returns whether or not the Compressor is running.
     *
     * @return A stored value that is set with setCompressorRunning().
     */
    static public boolean compressorRunning() {
        return compressorRunning;
    }

    /**
     * This sets the value to be returned by compressorRunning().
     *
     * @param running Whether or not the compressor is running.
     */
    static public void setCompressorRunning(boolean running) {
        compressorRunning = running;
    }
}
