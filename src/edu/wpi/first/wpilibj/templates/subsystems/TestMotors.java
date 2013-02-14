package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.TestDrive;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

public class TestMotors extends Subsystem {

    private Jaguar jag1, jag2;
    private RobotDrive drive;

    public TestMotors() {
        jag1 = new Jaguar(VstM.PWM.TEST_MOTOR_1_PORT);
        jag2 = new Jaguar(VstM.PWM.TEST_MOTOR_2_PORT);
        drive = new RobotDrive(jag1, jag2);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TestDrive());
    }

    public void drive(Joystick stick) {
        drive.arcadeDrive(stick);
    }

    public void stop() {
        jag1.stopMotor();
        jag2.stopMotor();
    }
}