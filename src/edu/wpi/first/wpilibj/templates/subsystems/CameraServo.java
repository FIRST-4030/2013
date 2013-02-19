package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunCameraServo;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author daboross
 */
public class CameraServo extends Subsystem implements Debuggable {

    private Servo cameraServo;
    private int setLast = -50;

    public CameraServo() {
        cameraServo = new Servo(VstM.PWM.CAMERA_SERVO);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunCameraServo());
    }

    public void turnLeft() {
        cameraServo.setAngle(0);
        setLast = 0;
    }

    public void turnRight() {
        cameraServo.setAngle(90);
        setLast = 90;
    }

    public DebugOutput getStatus() {
        return new DebugStatus("CameraServo", setLast, DebugLevel.MID);
    }
}
