package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;

public class ImageProcess extends CommandBase {

    private boolean finished = false;
    private ColorImage currentImage;
    private BinaryImage currentBImage;

    public ImageProcess() {
        requires(mainCamera);
    }

    protected void initialize() {
    }

    protected void execute() {
        calculate();
        finished = true;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        freeColorImage();
        freeBImage();
    }

    protected void interrupted() {
        end();
    }

    private void calculate() {
        getColorImage();
        if (currentImage != null) {
            getBImage();
            if (currentBImage != null) {
                freeColorImage();
            }
        }
    }

    private void getColorImage() {
        freeColorImage();
        currentImage = mainCamera.takePicture();
        if (currentImage == null) {
            System.err.println("ImageProcess getColorImage(): mainCamera gave null image.");
        }
    }
    private static final int HUE_LOW = 50;
    private static final int HUE_HIGH = 155;
    private static final int SAT_LOW = 60;
    private static final int SAT_HIGH = 255;
    private static final int LUM_LOW = 60;
    private static final int LUM_HIGH = 255;

    private void getBImage() {
        if (currentImage == null) {
            System.err.println("ImageProcess getBImage(): currentImage is NULL!");
            return;
        }
        freeBImage();
        try {
            currentBImage = currentImage.thresholdHSL(HUE_LOW, HUE_HIGH, SAT_LOW, SAT_HIGH, LUM_LOW, LUM_HIGH);
        } catch (NIVisionException ex) {
            System.err.println("ImageProcess getBImage(): Error While Getting currentImage's Threshold: " + ex + " " + ex.getMessage());
        }
    }

    private void freeColorImage() {
        if (currentImage != null) {
            try {
                currentImage.free();
            } catch (Exception ex) {
                System.err.println("ImageProcess freeColorImage(): Failed to free image with Exception: " + ex + " " + ex.getMessage());
            }
        }
    }

    private void freeBImage() {
        if (currentBImage != null) {
            try {
                currentBImage.free();
            } catch (Exception ex) {
                System.err.println("ImageProcess freeBImage(): Failed to free image with Exception: " + ex + " " + ex.getMessage());
            }
        }
    }
}
