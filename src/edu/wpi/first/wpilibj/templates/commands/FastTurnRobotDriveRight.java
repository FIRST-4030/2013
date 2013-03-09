package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author daboross
 */
public class FastTurnRobotDriveRight extends CommandBase {

    private static final double speedDif = 0.01;
    private boolean finished;
    private double speed;
    /**
     * State.
     *
     * 0 for speeding up.
     *
     * 1 for at max speed.
     *
     * 2 for slowing down.
     */
    private int state;
    /**
     * Time that speed reached max.
     */
    private long maxTimeStamp;

    public FastTurnRobotDriveRight() {
        requires(groundDrive);
    }

    private long getTimeOn2() {
        return 1000;
    }

    protected void initialize() {
        System.out.println("[FastTurnRight] Starting");
        state = 0;
        speed = groundDrive.getLastForwardMotion();
    }

    protected void execute() {
        if (state == 0) {
            if (speed + speedDif >= 1) {
                speed = 1;
                maxTimeStamp = System.currentTimeMillis();
                state = 1;
            } else {
                speed += speedDif;
            }
        } else if (state == 1) {
            if (System.currentTimeMillis() - maxTimeStamp > getTimeOn2()) {
                state = 2;
            }
        } else if (state == 2) {
            if (speed - speedDif <= 0) {
                speed = 0;
                finished = true;
                state = 3;
            } else {
                speed -= speedDif;
            }
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    }
}
