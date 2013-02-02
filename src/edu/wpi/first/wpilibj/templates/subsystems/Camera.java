package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.*;

/**
 * This is the CAMERA Sub System. Basically only allows you to get the current
 * AxisCamera image without hassle.
 */
public class Camera extends Subsystem {

    private AxisCamera camera = null;

    /**
     * Default constructor for Camera. Will get the current camera instance.
     */
    public Camera() {
        camera = this.getInstance();
    }

    public void initDefaultCommand() {
    }

    /**
     * This sets the Instance Variable camera to AxisCamera.getInstance()
     */
    private AxisCamera getInstance() {
        if (this.camera != null) {
            return this.camera;
        }
        AxisCamera axis;
        try {
            axis = AxisCamera.getInstance();
        } catch (Exception e) {
            axis = null;
        }
        if (axis == null) {
            System.err.println("Camera: Unable to initialize camera");
        }
        return axis;
    }

    /**
     * This gets the current IMAGE from the CAMERA
     */
    public ColorImage takePicture() {
        ColorImage image = null;
        try {
            image = camera.getImage();
        } catch (Exception e) {
            System.err.println("Camera: Unable to capture image from camera");
        }
        return image;
    }

    public AxisCamera getCamera() {
        return camera;
    }
}
