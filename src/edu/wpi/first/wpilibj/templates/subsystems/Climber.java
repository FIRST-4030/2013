/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimber;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author Robotics
 */
public class Climber extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Jaguar climber1 = new Jaguar(VstM.PWM.CLIMBER_MOTOR_1);
    private Jaguar climber2 = new Jaguar(VstM.PWM.CLIMBER_MOTOR_2);

    public void initDefaultCommand() {
        setDefaultCommand(new RunClimber());
    }
    
    private double currentSpeed = 0;

    public void raiseLadder() {
        climber1.set(0.5);
        climber2.set(0.5);
    }

    public void lowerLadder() {
        climber1.set(-0.5);
        climber2.set(-0.5);
    }
    
    public void stop() {
        climber1.set(0);
        climber2.set(0);
    }
    
    public void changeLadderSpeed(double d) {
        currentSpeed += d;
    }

    public void update() {
        currentSpeed *= 0.7;
    }
}
