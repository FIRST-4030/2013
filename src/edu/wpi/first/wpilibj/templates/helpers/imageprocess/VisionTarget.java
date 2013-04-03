//package edu.wpi.first.wpilibj.templates.helpers.imageprocess;
//
///**
// * Vision Target.
// */
//public class VisionTarget {
//
//    /**
//     * X position of closest vertex to origin.
//     */
//    private int x;
//    /**
//     * Z position of closest vertex to origin.
//     */
//    private int y;
//    /**
//     * Z position of closest vertex to origin.
//     */
//    private int z;
//    /**
//     * Delta y from extrema.
//     */
//    private int height;
//    /**
//     * Hypotenuse of delta x and delta z from extrema.
//     */
//    private int width;
//    /**
//     * Angle from x axis on the x-z plain.
//     */
//    private double angle;
//    /**
//     * What Target is this?.
//     *
//     * 0 for Left Middle Goal.
//     *
//     * 1 for Middle High Goal.
//     *
//     * 2 for Right Middle Goal.
//     *
//     * 3 for Right Low Goal.
//     */
//    private double whichTarget;
//
//    /**
//     * Creates a Vision Target from the given coordinates.
//     *
//     * @param x The X Position of this target.
//     * @param y The Y Position of this target.
//     * @param z The Z Position of this target.
//     * @param height The Height of this target.
//     * @param width The Width of this target.
//     * @param angle The Angle ? I am not sure what 0 would be ?
//     */
//    public VisionTarget(int x, int y, int z, int height, int width, double angle) {
//        this.x = x;
//        this.y = y;
//        this.z = z;
//        this.height = height;
//        this.width = width;
//        this.angle = angle;
//    }
//
//    /**
//     * Creates a Vision Target from the given coordinates with 0 angle.
//     *
//     * @param x The X Position of this target.
//     * @param y The Y Position of this target.
//     * @param z The Z Position of this target.
//     * @param height The Height of this target.
//     * @param width The Width of this target.
//     *
//     */
//    public VisionTarget(int x, int y, int z, int height, int width) {
//        this(x, y, z, height, width, 0);
//    }
//
//    /**
//     * Gets this Target's X Position.
//     */
//    public int getX() {
//        return x;
//    }
//
//    /**
//     * Gets this Target's Y Position.
//     */
//    public int getY() {
//        return y;
//    }
//
//    /**
//     * Gets this Target's Z position.
//     */
//    public int getZ() {
//        return z;
//    }
//
//    /**
//     * Gets this Target's Height.
//     */
//    public int getHeight() {
//        return height;
//    }
//
//    /**
//     * Gets this Target's Width.
//     */
//    public int getWidth() {
//        return width;
//    }
//
//    /**
//     * Gets this Target's Angle. ? Not sure what this is relative to ?
//     */
//    public double getAngle() {
//        return angle;
//    }
//
//    /**
//     * Not Finished? I have no idea what this does...
//     */
//    public RobotPositionReport GetLocBasedOnTarget(VisionTarget ideal) {
//        return null;
//    }
//}
