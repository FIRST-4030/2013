package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.commands.RunClimber;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.variablestores.VstM;

/**
 * This is the ClimberMotors SubSystem. It moves the "cart" up and down the
 * ladder on the robot.
 */
public final class ClimberMotors extends Subsystem {

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
     *
     * @param speed The speed to run at.
     * @throws IllegalArgumentException if speed is smaller than -1 or speed is
     * bigger than 1
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

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.MID, "ClimberMotors:Speed", climberMotors.get());
    }
}
