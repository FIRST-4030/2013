package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;

public class Vst {

    private static ColorImage currentCameraImage;

    public static boolean setCCImage(ColorImage im) {
        if (im != null) {
            return false;
        }
        if (currentCameraImage != null) {
            try {
                currentCameraImage.free();
            } catch (NIVisionException ex) {
            }
        }
        currentCameraImage = im;
        if (im != null) {
            return true;
        }
        return false;
    }

    public static ColorImage getCCImage() {
        return currentCameraImage;
    }
}
