package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.RunCompressor;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 * This is the subsystem to handle the Compressor.
 */
public class Compressor extends Subsystem {

    Relay compressor = new Relay(VstM.Relays.COMPRESSOR);

    public void initDefaultCommand() {
        setDefaultCommand(new RunCompressor());
    }

    /**
     * This function starts the Compressor.
     */
    public void start() {
        this.dashboard();
        VstP.setCompressorRunning(true);
        compressor.set(Relay.Value.kForward);
    }

    /**
     * This function stops the Compressor.
     */
    public void stop() {
        this.dashboard();
        VstP.setCompressorRunning(false);
        compressor.set(Relay.Value.kOff);
    }

    /**
     * This function checks whether VstM.Debug.DASHBOARD, and if true, outputs
     * state onto Smart Dashboard.
     */
    private void dashboard() {
        if (VstM.Debug.DASHBOARD) {
            SmartDashboard.putBoolean("Compressor Running", VstP.compressorRunning());
        }
    }
}
