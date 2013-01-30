package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command to Take Picture. This will take one picture from camera subsystem,
 * then print to console if that worked or not. Then it will exit after doing
 * that once. Also puts output onto the Smart Dashboard
 */
public class TakePicture extends CommandBase {

    private ColorImage currentImage = null;
    private boolean done = false;

    public TakePicture() {
        requires(mainCamera);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
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

    /**
     * Make this return true when this Command no longer needs to run execute().
     */
    protected boolean isFinished() {
        return done;
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
        freeImage();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     */
    protected void interrupted() {
    }

    /**
     * This frees the instance variable: currentImage, Hassle free.
     */
    private void freeImage() {
        if (currentImage != null) {
            try {
                currentImage.free();
            } catch (Exception e) {
                System.err.println("TakePicture freeImage(): Failed to Free Image");
            }
        }
    }

    /**
     * Sets the instance variable: currentImage
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
