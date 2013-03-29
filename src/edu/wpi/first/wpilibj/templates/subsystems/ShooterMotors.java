package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * This is a SubSystem for the Shooter Motors.
 */
public final class ShooterMotors extends Subsystem implements Debuggable {

    private Jaguar firstMotor = new Jaguar(VstM.PWM.FIRST_SHOOTER_MOTOR_PORT);
    private Jaguar secondMotor = new Jaguar(VstM.PWM.SECOND_SHOOTER_MOTOR_PORT);

    public ShooterMotors() {
        System.out.println("SubSystem Created: ShooterMotors");
        setSpeed(0, 0);
    }

    protected void initDefaultCommand() {
    }

    /**
     * Sets the speed of the shooter motors to this speed.
     *
     * @param speed the speed of the second motor.
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

    public DebugOutput getStatus() {
        DebugStatus[] infoList = new DebugStatus[2];
        infoList[0] = new DebugStatus("ShooterMotors:FirstMotor:Speed", firstMotor.get(), DebugLevel.MID);
        infoList[1] = new DebugStatus("ShooterMotors:SecondMotor:Speed", secondMotor.get(), DebugLevel.MID);
        return new DebugInfoGroup(infoList);
    }
}
