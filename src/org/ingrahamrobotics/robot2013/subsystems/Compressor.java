package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.commands.RunCompressor;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.variablestores.VstM;

/**
 * This is the subsystem to handle the Compressor.
 */
public class Compressor extends Subsystem {

    private final Relay compressor = new Relay(VstM.RELAY.COMPRESSOR_SPIKE);
    private boolean ranLast = false;

    /**
     * Default Constructor
     */
    public Compressor() {
        System.out.println("SubSystem Created: Compressor");
    }

    /**
     * Calls this.setDefaultCommand(new RunCompressor());
     */
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
            this.outputStatus();
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
            this.outputStatus();
        }
    }

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.MID, "Compressor:RanLast", ranLast);
    }
}
