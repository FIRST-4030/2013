package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.templates.helpers.ProcessError;
import edu.wpi.first.wpilibj.templates.subsystems.Camera;
import edu.wpi.first.wpilibj.templates.variablestores.VstC;

/**
 *
 * @author daboross
 */
public class ImageProcessMain {

    private static ColorImage currentImage;
    private static BinaryImage currentBImage;
    private static ParticleAnalysisReport[] particleAnalysisReportList;
    private static Camera mainCamera;

    public static void runReport(Camera mC) {
        mainCamera = mC;
        LinearDistanceReport ldp = calculateLinear();
        freeColorImage();
        freeBImage();
    }

    /**
     * Main Calculation Function.
     */
    private static LinearDistanceReport calculateLinear() {
        ProcessError possibleError = new ProcessError("ImageProcessMain");
        getColorImage(possibleError);
        if (currentImage != null && !possibleError.isError()) {
            try {
                VstC.PIXEL_HEIGHT_OF_CAMERA = currentImage.getHeight();
                VstC.PIXEL_WIDTH_OF_CAMERA = currentImage.getWidth();
            } catch (Exception ex) {
                return new LinearDistanceReport(new ProcessError("ImageProcessMain calculateLinear", ex.toString() + " while getting current height/width from current Image."));
            }
            getBImage(possibleError);
            if (currentBImage != null && !possibleError.isError()) {
                freeColorImage();
                if (getReportList(possibleError) && !possibleError.isError()) {
                    int numberOfTargets = filterReportList(possibleError);
                    if (numberOfTargets > 0 && !possibleError.isError()) {
                        return LinearDistanceCalculator.calculateLinearDistance(particleAnalysisReportList);
                    }
                    return possibleError.isError() ? new LinearDistanceReport(possibleError) : new LinearDistanceReport(new ProcessError("ImageProcessMain calculateLinear", "No Reports In List"));
                }
                return new LinearDistanceReport(possibleError.isError() ? possibleError : new ProcessError("ImageProcessMain", "Error Processing Report List"));
            }
            return new LinearDistanceReport(possibleError.isError() ? possibleError : new ProcessError("ImageProcessMain", "Current BImage Null"));
        }
        return new LinearDistanceReport(possibleError.isError() ? possibleError : new ProcessError("ImageProcessMain", "Color Image Null"));
    }

    /**
     * Frees currentImage, then gets a new image from mainCamera.takePicture().
     */
    private static void getColorImage(ProcessError possible) {
        freeColorImage();
        currentImage = mainCamera.takePicture();
        if (currentImage == null) {
            possible.setErrored("getColorImage", "mainCamera gave null image.");
        }
    }

    /**
     * Frees the variable currenBImage, then gets a new one from currentImage.
     */
    private static void getBImage(ProcessError possible) {
        if (currentImage == null) {
            possible.setErrored("getBImage", "Null Current Image");
            return;
        }
        freeBImage();
        try {
            currentBImage = currentImage.thresholdHSL(VstC.HUE_LOW, VstC.HUE_HIGH, VstC.SAT_LOW, VstC.SAT_HIGH, VstC.LUM_LOW, VstC.LUM_HIGH);
        } catch (NIVisionException ex) {
            possible.setErrored("getBImage", "Error While Getting currentImage's Threshold: " + ex + " " + ex.getMessage());
        }
    }

    /**
     * Frees the instance variable currentImage.
     */
    private static void freeColorImage() {
        if (currentImage != null) {
            try {
                currentImage.free();
                currentImage = null;
            } catch (Exception ex) {
                System.err.println("ImageProcess freeColorImage(): Failed to free image with Exception: " + ex + " " + ex.getMessage());
            }
        }
    }

    /**
     * Frees the instance variable currentBImage.
     */
    private static void freeBImage() {
        if (currentBImage != null) {
            try {
                currentBImage.free();
                currentBImage = null;
            } catch (Exception ex) {
                System.err.println("ImageProcess freeBImage(): Failed to free image with Exception: " + ex + " " + ex.getMessage());
            }
        }
    }

    /**
     * Sets the variable particleAnalysisReportList from currentBImage.
     *
     * @return True if successful, False otherwise.
     */
    private static boolean getReportList(ProcessError errorToPrintTo) {
        if (currentBImage == null) {
            errorToPrintTo.setErrored("getReportList", "Current BImage is Null");
            return false;
        }
        try {
            particleAnalysisReportList = currentBImage.getOrderedParticleAnalysisReports();
        } catch (Exception ex) {
            errorToPrintTo.setErrored("getReportList", "Exception getting OrderedParticleAnalysisReports from currentBImage: " + ex + " " + ex.getMessage());
            return false;
        }
        if (particleAnalysisReportList == null) {
            errorToPrintTo.setErrored("getReportList", "particleAnalysisReportList is NULL!");
            return false;
        }
        return true;
    }

    private static int filterReportList(ProcessError possible) {
        if (particleAnalysisReportList == null) {
            possible.setErrored("filterReportList", "Null Report");
            return -1;
        }
        // PUT CODE HERE TO FILTER REPORT LIST!
        return particleAnalysisReportList.length;
    }
}
