package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstCamera;

/**
 *
 * @author daboross
 */
public class RunCameraServo extends CommandBase {

    public RunCameraServo() {
        requires(cameraServo);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (DVstCamera.cameraPosition()) {
            cameraServo.turnLeft();

        } else {
            cameraServo.turnRight();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
}
