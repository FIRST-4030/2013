package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunCompressor;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.infos.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This is the subsystem to handle the Compressor.
 */
public class Compressor extends Subsystem implements Debuggable {

    private final Relay compressor = new Relay(VstM.RELAY.COMPRESSOR_SPIKE);
    private boolean ranLast = false;

    public Compressor() {
        System.out.println("SubSystem Created: Compressor");
    }

    public void initDefaultCommand() {
        setDefaultCommand(new RunCompressor());
    }

    /**
     * This function starts the Compressor. This DOES auto-push this class.
     */
    public void start() {
        boolean changed = !ranLast;
        ranLast = true;
        compressor.set(Relay.Value.kOn);
        if (changed) {
            RobotDebugger.push(this);
        }
    }

    /**
     * This function stops the Compressor. This DOES auto-push this class.
     */
    public void stop() {
        boolean changed = ranLast;
        ranLast = false;
        compressor.set(Relay.Value.kOff);
        if (changed) {
            RobotDebugger.push(this);
        }
    }

    public DebugOutput getStatus() {
        return new DebugStatus("Compressor:RanLast", ranLast, DebugLevel.MID);
    }
}
