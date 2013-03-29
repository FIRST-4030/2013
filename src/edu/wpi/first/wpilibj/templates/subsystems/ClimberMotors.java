package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimber;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This is the ClimberMotors SubSystem. It moves the "cart" up and down the
 * ladder on the robot.
 */
public final class ClimberMotors extends Subsystem implements Debuggable {

    private Jaguar climberMotors = new Jaguar(VstM.PWM.CLIMBER_MOTOR_PORT);

    public ClimberMotors() {
        System.out.println("SubSystem Created: Climber");
    }

    public void initDefaultCommand() {
        setDefaultCommand(new RunClimber());
    }

    public void runLadder(final double speed) {
        if (speed < -1 || speed > 1) {
            throw new IllegalArgumentException("To High/Low a value passed in runLadder(double)");
        }
        climberMotors.set(speed);
    }

    public void stop() {
        climberMotors.stopMotor();
    }

    public DebugOutput getStatus() {
        return new DebugStatus("ClimberMotors:Speed", climberMotors.get(), DebugLevel.MID);
    }
}
