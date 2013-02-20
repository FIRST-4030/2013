package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstP;

/**
 * This Command continously checks whether or not VstP.atPressure(), and sets
 * the Compressor state accordingly.
 */
public class RunCompressor extends CommandBase {

    public RunCompressor() {
        requires(compressor);
    }

    protected void initialize() {
        compressor.stop();
    }

    protected void execute() {
        if (DVstP.atPressure()) {
            compressor.stop();
        } else {
            compressor.start();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        compressor.stop();
    }
}
