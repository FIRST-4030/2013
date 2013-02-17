package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimber;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This is the Climber Motor SubSystem. It moves the "cart" up and down the
 * ladder on the robot.
 */
public class Climber extends Subsystem implements Debuggable {

    private Jaguar climber = new Jaguar(VstM.PWM.CLIMBER_MOTOR_PORT);

    public void initDefaultCommand() {
        setDefaultCommand(new RunClimber());
    }

    public void runLadder(double speed) {
        //TODO Should we check if this value is between -1 and 1? Or what kind of input can the Jaguar take?
        climber.set(speed);
    }

    public void stop() {
        climber.stopMotor();
    }

    public DebugOutput getStatus() {
        return new DebugStatus("Climber:Speed", climber.get());
    }
}
