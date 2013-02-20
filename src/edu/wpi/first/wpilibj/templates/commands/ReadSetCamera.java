/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 *
 * @author profplump
 */
public class ReadSetCamera extends CommandBase {
    
    public ReadSetCamera() {
        requires(mainCamera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        AxisCamera camera = mainCamera.getCamera();
        System.err.println("Brightness: " + camera.getBrightness());
        System.err.println("ColorLevel: " + camera.getColorLevel());
        System.err.println("Compression: " + camera.getCompression());
        System.err.println("ExposureControl: " + camera.getExposureControl());
        System.err.println("ExposurePriority: " + camera.getExposurePriority());
        System.err.println("MaxFPS: " + camera.getMaxFPS());
        System.err.println("Resolution: " + camera.getResolution());
        System.err.println("Rotation: " + camera.getRotation());
        System.err.println("WhiteBalance: " + camera.getWhiteBalance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }
}
