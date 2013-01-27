package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.image.*;

/**
 * Command to Take Picture
 */
public class TakePicture extends CommandBase {

    private ColorImage currentImage = null;
    private boolean done = false;

    public TakePicture() {
        requires(camera);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        getImage();
        if (currentImage == null) {
            System.out.println("TakePicture execute(): Image not capture");
        } else {
            System.out.println("TakePicture execute(): Image captured");
            freeImage();
        }
        done = true;
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        return done;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }

    /**
     * This frees the instance variable: currentImage, Hassle free!
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
        currentImage = camera.takePicture();
    }
}
