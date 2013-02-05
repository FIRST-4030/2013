package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

/**
 * Robot Position Report.
 */
public class RobotPositionReport {

    /**
     * X Position of the Robot.
     */
    private int x;
    /**
     * Y Position of the Robot.
     */
    private int y;
    /**
     * Z Position of the Robot.
     */
    private int z;
    /**
     * Yaw of the Robot.
     */
    private int yaw;
    /**
     * Pitch of the Robot.
     */
    private int pitch;

    /**
     * Main Constructor for Robot Position Report.
     */
    public RobotPositionReport(int x, int y, int z, int yaw, int pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    /**
     * Gets This Report's X Position.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets This Report's X Position.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets This Report's Y Position.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets This Report's Y Position.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets This Report's Z Position.
     */
    public int getZ() {
        return z;
    }

    /**
     * Sets This Report's Z Position.
     */
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Gets This Report's Yaw.
     */
    public int getYaw() {
        return yaw;
    }

    /**
     * Sets This Report's Yaw.
     */
    public void setYaw(int yaw) {
        this.yaw = yaw;
    }

    /**
     * Gets This Report's Pitch.
     */
    public int getPitch() {
        return pitch;
    }

    /**
     * Sets This Report's Pitch.
     */
    public void setPitch(int pitch) {
        this.pitch = pitch;
    }
}
