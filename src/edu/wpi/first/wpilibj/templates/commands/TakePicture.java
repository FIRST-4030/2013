package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.image.*;

/**
 *
 * @author bradmiller
 */
public class TakePicture extends CommandBase {

    public TakePicture() {
        requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ColorImage image = camera.takePicture();
        
        if (image != null) {
            System.out.println("Image captured!");
        } else {
            System.out.println("Image not capture :-(");
        }

        if (image != null) {
            try {
                image.free();
            } catch (Exception e) {
            }
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
