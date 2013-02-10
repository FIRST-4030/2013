package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

public class TestMotors extends Subsystem {

    private Jaguar jag1, jag2;
    private RobotDrive drive;

    public TestMotors() {
        jag1 = new Jaguar(VstM.PWM.TEST_MOTOR_1);
        jag2 = new Jaguar(VstM.PWM.TEST_MOTOR_2);
    }

    public void initDefaultCommand() {
        setDefaultCommand(null);
    }

    public void drive(Joystick stick) {
        drive = new RobotDrive(jag1, jag2);
        drive.arcadeDrive(stick);
    }

    public void stop() {
        drive.free();
        jag1.stopMotor();
        jag2.stopMotor();
    }
}
