package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.RunCompressor;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

public class Compressor extends Subsystem {

    Relay compressor = new Relay(VstM.Relays.COMPRESSOR);

    public void initDefaultCommand() {
        setDefaultCommand(new RunCompressor());
    }

    public void start() {
        this.dashboard();
        VstP.setCompressorRunning(true);
        compressor.set(Relay.Value.kForward);
    }

    public void stop() {
        this.dashboard();
        VstP.setCompressorRunning(false);
        compressor.set(Relay.Value.kOff);
    }

    private void dashboard() {
        if (VstM.Debug.DASHBOARD) {
            SmartDashboard.putBoolean("Compressor Running", VstP.compressorRunning());
        }
    }
}
