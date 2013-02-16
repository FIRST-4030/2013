package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunShooterMotors;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 */
public final class ShooterMotors extends Subsystem implements Debuggable {

    private Jaguar firstMotor = new Jaguar(VstM.PWM.FIRST_SHOOTER_MOTOR_PORT);
    private Jaguar secondMotor = new Jaguar(VstM.PWM.SECOND_SHOOTER_MOTOR_PORT);

    public ShooterMotors() {
        setSpeed(0);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunShooterMotors());
    }

    /**
     * Sets the speed of the second motor to this speed, and the first motor to
     * .75 times this speed.
     *
     * @param speed the speed of the second motor.
     * @throws IllegalArgumentException If the given double is less then 0 or
     * more then 1.
     */
    public void setSpeed(double speed) {
        if (speed > 1 || speed < 0) {
            throw new IllegalArgumentException();
        }
        firstMotor.set(speed * 0.75);
        secondMotor.set(speed);
    }

    public DebugInfoGroup getStatus() {
        DebugStatus[] infoList = new DebugStatus[2];
        infoList[0] = new DebugStatus("ShooterMotors:FirstMotorSpeed", firstMotor.get());
        infoList[1] = new DebugStatus("ShooterMotors:SecondMotorSpeed", secondMotor.get());
        return new DebugInfoGroup(infoList);
    }
}
