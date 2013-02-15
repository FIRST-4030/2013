package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunCompressor;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 * This is the subsystem to handle the Compressor.
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
        compressor.set(Relay.Value.kForward);
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

    public DebugInfoGroup getStatus() {
        DebugInfo info = new DebugInfo("Compressor:ShouldRun", (VstP.compressorRunning() ? "yes" : "no"));
        return new DebugInfoGroup(info);
    }
}
