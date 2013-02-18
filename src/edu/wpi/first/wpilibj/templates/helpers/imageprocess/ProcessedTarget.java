package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.templates.variablestores.VstC;

/**
 * Processed Target.
 */
public class ProcessedTarget {

    /**
     * Height Of This Target On Screen.
     */
    private int height;
    /**
     * Width Of This Target On Screen.
     */
    private int width;
    /**
     * XPos On Screen.
     */
    private int posX;
    /**
     * YPos On Screen.
     */
    private int posY;
    /**
     * What Target This Target Is.
     */
    private int whichTarget;

    public ProcessedTarget(ParticleAnalysisReport p) {
        height = p.boundingRectHeight;
        width = p.boundingRectWidth;
        posX = p.boundingRectTop;
        posY = p.boundingRectLeft;
    }

    /**
     * This will try to detect what target this is.
     */
    private void findWhichTarget() {
        //CODE TO FIND WHICH TARGET THIS TARGET IS. EG MIDDLE HIGH, OR LOW TARGET.
    }

    /**
     * If This is called, it should be directly after this ProcessedTarget is
     * created.
     */
    public VisionTarget getVisionTarget(RobotPositionReport rpp) {
        return null;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getArea() {
        return height * width;
    }

    /**
     * UNIMPLIMENTED. Function to find height from ground. In FEET.
     */
    public double getDistanceFromGround() {
        return 20;
    }
}
