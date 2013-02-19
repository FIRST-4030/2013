package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command to Take Picture. This will take one picture from camera subsystem,
 * then print to console if that worked or not. Then it will exit after doing
 * that once. Also puts output onto the Smart Dashboard.
 */
public class TakePicture extends CommandBase {

    private ColorImage currentImage = null;
    private boolean done = false;

    /**
     * Default Constructor.
     */
    public TakePicture() {
        requires(mainCamera);
    }

    protected void initialize() {
    }

    protected void execute() {
        getImage();
        if (currentImage == null) {
            System.out.println("TakePicture execute(): Image not capture");
            SmartDashboard.putBoolean("Image Capture ", false);
        } else {
            System.out.println("TakePicture execute(): Image captured");
            SmartDashboard.putBoolean("Image Capture ", true);
        }
        done = true;
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
        freeImage();
    }

    /**
     * This frees the instance variable: currentImage.
     */
    private void freeImage() {
        if (currentImage != null) {
            try {
                currentImage.free();
                currentImage = null;
            } catch (Exception e) {
                System.err.println("TakePicture freeImage(): Failed to Free Image");
            }
        }
    }

    /**
     * Sets the instance variable: currentImage.
     */
    private void getImage() {
        freeImage();
        if (mainCamera != null) {
            currentImage = mainCamera.takePicture();
        } else {
            System.err.println("TakePicture getImage(): mainCamera is null!");
        }
    }
}
