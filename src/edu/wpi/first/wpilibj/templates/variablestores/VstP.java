/*
 * Pneumatics variable store
 */
package edu.wpi.first.wpilibj.templates.variablestores;

public class VstP {
    static private boolean atPressure = false;
    static private boolean compressorRunning = false;
    
    static public boolean atPressure() {
        return atPressure;
    }
    
    static public void setAtPressure(boolean atP) {
        atPressure = atP;
    }
    
    static public boolean compressorRunning() {
        return compressorRunning;
    }
    
    static public void setCompressorRunning(boolean running) {
        compressorRunning = running;
    }
}
