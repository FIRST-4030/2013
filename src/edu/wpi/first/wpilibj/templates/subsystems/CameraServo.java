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

    private final Servo cameraServo = new Servo(VstM.PWM.CAMERA_SERVO);

    public CameraServo() {
        System.out.println("SubSystem Created: CameraServo");
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunCameraServo());
    }

    public void turnLeft() {
        cameraServo.setAngle(150);
    }

    public void turnRight() {
        cameraServo.setAngle(45);
    }

    public DebugOutput getStatus() {
        return new DebugStatus("CameraServo:Angle", cameraServo.getAngle(), DebugLevel.MID);
    }
}
