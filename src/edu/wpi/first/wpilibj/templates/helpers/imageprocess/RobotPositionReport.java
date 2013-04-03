//package edu.wpi.first.wpilibj.templates.helpers.imageprocess;
//
///**
// * Robot Position Report.
// */
//public class RobotPositionReport {
//
//    /**
//     * X Position of the Robot.
//     */
//    private double x;
//    /**
//     * Y Position of the Robot. This should be the BOTTOM of the robot, not the
//     * position of the axis camera!
//     */
//    private double y;
//    /**
//     * Z Position of the Robot.
//     */
//    private double z;
//    /**
//     * Yaw of the Robot.
//     */
//    private double yaw;
//    /**
//     * Pitch of the Robot.
//     */
//    private double pitch;
//
//    /**
//     * Main Constructor for Robot Position Report.
//     */
//    public RobotPositionReport(double x, double y, double z, double yaw, double pitch) {
//        this.x = x;
//        this.y = y;
//        this.z = z;
//        this.yaw = yaw;
//        this.pitch = pitch;
//    }
//
//    private RobotPositionReport(RobotPositionReport rpp) {
//        x = rpp.getX();
//        y = rpp.getY();
//        z = rpp.getZ();
//        yaw = rpp.getYaw();
//        pitch = rpp.getPitch();
//    }
//
//    /**
//     * Gets This Report's X Position.
//     */
//    public double getX() {
//        return x;
//    }
//
//    /**
//     * Sets This Report's X Position.
//     */
//    public void setX(double x) {
//        this.x = x;
//    }
//
//    /**
//     * Gets This Report's Y Position.
//     */
//    public double getY() {
//        return y;
//    }
//
//    /**
//     * Sets This Report's Y Position.
//     */
//    public void setY(double y) {
//        this.y = y;
//    }
//
//    /**
//     * Gets This Report's Z Position.
//     */
//    public double getZ() {
//        return z;
//    }
//
//    /**
//     * Sets This Report's Z Position.
//     */
//    public void setZ(double z) {
//        this.z = z;
//    }
//
//    /**
//     * Gets This Report's Yaw.
//     */
//    public double getYaw() {
//        return yaw;
//    }
//
//    /**
//     * Sets This Report's Yaw.
//     */
//    public void setYaw(double yaw) {
//        this.yaw = yaw;
//    }
//
//    /**
//     * Gets This Report's Pitch.
//     */
//    public double getPitch() {
//        return pitch;
//    }
//
//    /**
//     * Sets This Report's Pitch.
//     */
//    public void setPitch(double pitch) {
//        this.pitch = pitch;
//    }
//
//    /**
//     * This Creates a new RobotPositionReport with the same values as this.
//     * Performs a deep copy.
//     */
//    public RobotPositionReport copy() {
//        return new RobotPositionReport(this);
//    }
//}
