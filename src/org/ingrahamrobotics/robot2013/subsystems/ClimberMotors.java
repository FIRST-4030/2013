package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.commands.RunClimber;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.infos.DebugStatus;
import org.ingrahamrobotics.robot2013.debugging.DebugOutput;
import org.ingrahamrobotics.robot2013.debugging.Debuggable;
import org.ingrahamrobotics.robot2013.variablestores.VstM;

/**
 * This is the ClimberMotors SubSystem. It moves the "cart" up and down the
 * ladder on the robot.
 */
public final class ClimberMotors extends Subsystem implements Debuggable {

    private final Jaguar climberMotors = new Jaguar(VstM.PWM.CLIMBER_MOTOR_PORT);

    /**
     * Default Constructor
     */
    public ClimberMotors() {
        System.out.println("SubSystem Created: Climber");
    }

    /**
     * Calls this.setDefaultCommand(new RunClimber());
     */
    public void initDefaultCommand() {
        setDefaultCommand(new RunClimber());
    }

    /**
     * Runs the climber ladder motors at the given speed
     */
    public void runLadder(final double speed) {
        if (speed < -1 || speed > 1) {
            throw new IllegalArgumentException("To High/Low a value passed in runLadder(double)");
        }
        climberMotors.set(speed);
    }

    /**
     * Stops the climber ladder motors
     */
    public void stop() {
        climberMotors.stopMotor();
    }

    /**
     * @return a DebugOutput representing the status of this command.
     */
    public DebugOutput getStatus() {
        return new DebugStatus("ClimberMotors:Speed", climberMotors.get(), DebugLevel.MID);
    }
}
