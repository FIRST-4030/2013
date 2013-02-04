/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

/**
 *
 * @author Ingyram
 */
public class VisionTarget {
    /**
     * x position of closest vertex to origin
     */
    private int x;
    /**
     * y position of closest vertex to origin
     */
    private int y;
    /**
     * z position of closest vertex to origin
     */
    private int z;
    /**
     *  delta y from extrema
     */
    private int height;
    /**
     * hypotonus of delta x and delta z from extrema
     */
    private int width;
    /**
     * angle from x axis on the x-z plain
     */
    private double angle;
    
    public VisionTarget(int x, int y, int z, int height, int width, double angle){
        this.x=x;
        this.y=y;
        this.z=z;
        this.height=height;
        this.width=width;
        this.angle=angle;
    }
    public VisionTarget(int x, int y, int z, int height, int width){
        this(x,y,z,height,width,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double getAngle() {
        return angle;
    }
    
    public RobotPositionReport GetLocBasedOnTarget(VisionTarget ideal){
        int viewAngle=0;
        return null; 
    }
    
    
    
}
