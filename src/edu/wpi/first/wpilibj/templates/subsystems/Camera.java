package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.*;

/**
 * This is the CAMERA Sub System. Basically only allows you to get the current
 * AxisCamera image without hassle.
 */
public class Camera extends Subsystem {

    public static final boolean cameraEnabled = false;
    private static AxisCamera camera = null;

    /**
     * Default constructor for Camera. Will get the current camera instance.
     */
    public Camera() {
        setCameraInstance();

    }

    public void initDefaultCommand() {
    }

    /**
     * This sets the Instance Variable camera to AxisCamera.getInstance().
     */
    private void setCameraInstance() {
        if (camera != null || !cameraEnabled) {
            return;
        }
        AxisCamera axis;
        try {
            axis = AxisCamera.getInstance();
        } catch (Throwable t) {
            axis = null;
        }
        if (axis != null) {
            camera = axis;
        }
    }

    /**
     * This gets the current IMAGE from the CAMERA.
     */
    public ColorImage takePicture() {
        if (!cameraEnabled) {
            System.out.println("CAMERA: Tried to get picture when camera was disabled!!!!! Change this in Camera.java");
            return null;
        }
        setCameraInstance();
        ColorImage image = null;
        try {
            image = camera.getImage();
        } catch (Throwable t) {
        }
        return image;
    }

    public AxisCamera getCamera() {
        setCameraInstance();
        return camera;
    }
}
