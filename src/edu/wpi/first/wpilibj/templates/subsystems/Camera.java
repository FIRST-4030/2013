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
        setCameraInstance();
    }

    public void initDefaultCommand() {
    }

    /**
     * This sets the Instance Variable camera to AxisCamera.getInstance()
     */
    private void setCameraInstance() {
        if (this.camera != null) {
            return;
        }
        AxisCamera axis;
        try {
            axis = AxisCamera.getInstance();
        } catch (Exception e) {
            axis = null;
        }
        if (axis == null) {
            System.err.println("Camera: Unable to initialize camera");
        } else {
            camera = axis;
        }

    }

    /**
     * This gets the current IMAGE from the CAMERA.
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
        setCameraInstance();
        return camera;
    }
}
