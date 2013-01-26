package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

    private AxisCamera camera = null;

    public Camera() {
        camera = this.getInstance();
    }

    private AxisCamera getInstance() {
        if (this.camera != null) {
            return this.camera;
        }

        AxisCamera axis = null;
        try {
            axis = AxisCamera.getInstance();
        } catch (Exception e) {
            axis = null;
        }
        if (axis == null) {
            System.err.println("Unable to initialize camera");
        }
        return axis;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public ColorImage takePicture() {
        ColorImage image = null;

        try {
            image = camera.getImage();
        } catch (Exception e) {
            System.err.println("Unable to capture image from camera");
        }

        return image;
    }
}
