package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.variablestores.VstM;

/**
 * This is a SubSystem for the Shooter Motors.
 */
public final class ShooterMotors extends Subsystem {

    private final Jaguar firstMotor = new Jaguar(VstM.PWM.FIRST_SHOOTER_MOTOR_PORT);
    private final Jaguar secondMotor = new Jaguar(VstM.PWM.SECOND_SHOOTER_MOTOR_PORT);

    public ShooterMotors() {
        System.out.println("SubSystem Created: ShooterMotors");
        setSpeed(0, 0);
    }

    protected void initDefaultCommand() {
    }

    /**
     * Sets the speed of the shooter motors to this speed.
     *
     * @param speed1 the speed of the first motor.
     * @param speed2 the speed of the second motor.
     * @throws IllegalArgumentException If the given double is less then 0 or
     * more then 1.
     */
    public void setSpeed(double speed1, double speed2) {
        if (speed1 > 1 || speed1 < 0 || speed2 > 1 || speed2 < 0) {
            throw new IllegalArgumentException();
        }
        firstMotor.set(speed1);
        secondMotor.set(speed2);
    }

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.MID, "ShooterMotors:FirstMotor:Speed", firstMotor.get());
        RobotDebugger.output(DebugLevel.MID, "ShooterMotors:SecondMotor:Speed", secondMotor.get());
    }
}
