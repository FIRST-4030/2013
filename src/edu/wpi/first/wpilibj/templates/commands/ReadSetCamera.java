package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 *
 * @author profplump
 */
public class ReadSetCamera extends CommandBase {

    public ReadSetCamera() {
        requires(mainCamera);
    }

    protected void initialize() {
    }

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

    protected boolean isFinished() {
        this.execute();
        return true;
    }

    protected void end() {
    }
}
