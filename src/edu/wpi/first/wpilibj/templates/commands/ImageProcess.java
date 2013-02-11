package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.helpers.imageprocess.ImageProcessMain;

/**
 * This is a Command that initializes Image Processing once, then is finished.
 */
public class ImageProcess extends CommandBase {

    private boolean finished = false;

    public ImageProcess() {
        requires(mainCamera);
    }

    protected void initialize() {
    }

    protected void execute() {
        ImageProcessMain.runReport(mainCamera);
        finished = true;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
