/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.RunCompressor;
import edu.wpi.first.wpilibj.templates.variablestores.VstP;

/**
 *
 * @author Ingyram
 */
public class Compressor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Relay compressor = new Relay(1);
    
    public void initDefaultCommand() {
        setDefaultCommand(new RunCompressor());
    }
    
    public void start() {
        SmartDashboard.putBoolean("Compressor Running", true);
        VstP.setCompressorRunning(true);
        compressor.set(Relay.Value.kForward);
    }
    
    public void stop() {
        SmartDashboard.putBoolean("Compressor Running", false);
        VstP.setCompressorRunning(false);
        compressor.set(Relay.Value.kOff);
    }
}
