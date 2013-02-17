package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunCompressor;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 * This is the subsystem to handle the Compressor. It will power depending on VstP values.
 */
public class Compressor extends Subsystem implements Debuggable {

    Relay compressor = new Relay(VstM.Relays.COMPRESSOR);

    public void initDefaultCommand() {
        setDefaultCommand(new RunCompressor());
    }

    /**
     * This function starts the Compressor.
     */
    public void start() {
        VstP.setCompressorRunning(true);
        compressor.set(Relay.Value.kOn);
        RobotDebugger.push(this);
    }

    /**
     * This function stops the Compressor.
     */
    public void stop() {
        VstP.setCompressorRunning(false);
        compressor.set(Relay.Value.kOff);
        RobotDebugger.push(this);
    }

    public DebugOutput getStatus() {
        return new DebugStatus("Compressor:ShouldRun", (VstP.compressorRunning() ? "yes" : "no"));
    }
}
