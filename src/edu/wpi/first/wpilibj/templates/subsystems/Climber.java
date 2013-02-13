/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimber;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author Robotics
 */
public class Climber extends Subsystem {

    //objects needed by climber
    private Jaguar climber = new Jaguar(VstM.PWM.CLIMBER_MOTOR);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        setDefaultCommand(new RunClimber());
    }
    
    public void runLadder(double speed) {
        climber.set(speed);
    }

    public void stop() {
        climber.stopMotor();
    }
}
