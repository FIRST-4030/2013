package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 *
 * @author daboross
 */
public class ProcessedTarget {

    private int height;
    private int width;
    private int posX;
    private int posY;

    public ProcessedTarget(ParticleAnalysisReport p) {
        height = p.boundingRectHeight;
        width = p.boundingRectWidth;
        posX = p.boundingRectTop;
        posY = p.boundingRectLeft;
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
}
