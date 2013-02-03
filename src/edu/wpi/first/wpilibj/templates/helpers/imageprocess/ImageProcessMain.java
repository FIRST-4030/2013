package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Vst;
import edu.wpi.first.wpilibj.templates.subsystems.Camera;

/**
 *
 * @author daboross
 */
public class ImageProcessMain {

    private static ColorImage currentImage;
    private static BinaryImage currentBImage;
    private static ParticleAnalysisReport[] particleAnalysisReportList;
    private static Camera mainCamera;

    public static void runMe(Camera mC) {
        mainCamera = mC;
        SmartDashboard.putBoolean("ImageProcess", calculate() == null);
        freeColorImage();
        freeBImage();
    }

    /**
     * Main Calculation Function.
     */
    private static DistanceReport calculate() {
        getColorImage();
        if (currentImage != null) {
            try {
                Vst.PIXEL_HEIGHT_OF_CAMERA = currentImage.getHeight();
                Vst.PIXEL_WIDTH_OF_CAMERA = currentImage.getWidth();
            } catch (NIVisionException ex) {
                System.err.println("ImageProcess calculate(): NIVisionException when getting current height/width from current Image.");
            }
            getBImage();
            if (currentBImage != null) {
                freeColorImage();
                if (getReportList()) {
                    int numberOfTargets = filterReportList();
                    if (numberOfTargets > 0) {
                        return DistanceCalculator.calculate(particleAnalysisReportList);
                    } else {
                        System.out.println("ImageProcess calculate(): No Reports");
                        SmartDashboard.putNumber("Targets", numberOfTargets);
                    }
                } else {
                    System.out.println("ImageProcess calculate(): Get Report List Failed");
                }
            } else {
                System.out.println("ImageProcess calculate(): Binary Image Null.");
            }
        } else {
            System.out.println("ImageProcess calculate(): Color Image Null.");
        }
        return null;
    }

    /**
     * Frees currentImage, then gets a new image from mainCamera.takePicture().
     */
    private static void getColorImage() {
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

    /**
     * Frees the variable currenBImage, then gets a new one from currentImage.
     */
    private static void getBImage() {
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
    private static boolean getReportList() {
        if (currentBImage == null) {
            System.err.println("ImageProcess getReportList(): currentBImage is NULL!");
            return false;
        }
        try {
            particleAnalysisReportList = currentBImage.getOrderedParticleAnalysisReports();
        } catch (Exception ex) {
            System.err.println("ImageProcess getReportList(): Exception getting OrderedParticleAnalysisReports from currentBImage: " + ex + " " + ex.getMessage());
            return false;
        }
        if (particleAnalysisReportList == null) {
            System.err.println("ImageProcess getReportList(): particleAnalysisReportList is NULL!");
            return false;
        }
        return true;
    }

    private static int filterReportList() {
        if (particleAnalysisReportList == null) {
            System.err.println("Image Process filterReportList(): null report");
            return -1;
        }
        return particleAnalysisReportList.length;
    }
}
