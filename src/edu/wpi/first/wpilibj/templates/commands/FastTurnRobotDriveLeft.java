package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author daboross
 */
public class FastTurnRobotDriveLeft extends CommandBase {

    private static final double speedDif = -0.1;
    private static final double reverseSpeedDif = -0.3;
    private static final long timeOn = 100;
    private static final long timeReversed = 1;
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
    /**
     * Time that the speed reached 0.
     */
    private long doneTimeStamp;

    public FastTurnRobotDriveLeft() {
        requires(groundDrive);
    }

    protected void initialize() {
        System.out.println("[FastTurnLeft] Starting");
        state = 0;
        finished = false;
        speed = groundDrive.getLastSpinMotion();
    }

    protected void execute() {
        if (state == 0) {
            if (speed + speedDif <= -1) {
                speed = -1;
                maxTimeStamp = System.currentTimeMillis();
                state = 1;
            } else {
                speed += speedDif;
            }
        } else if (state == 1) {
            if (System.currentTimeMillis() - maxTimeStamp > timeOn) {
                state = 2;
            }
        } else if (state == 2) {
            if (speed - reverseSpeedDif >= 0) {
                speed = -speedDif;
                state = 3;
                doneTimeStamp = System.currentTimeMillis();
            } else {
                speed -= reverseSpeedDif;
            }
        } else if (state == 3) {
            if (System.currentTimeMillis() - doneTimeStamp > timeReversed) {
                speed = 0;
                finished = true;
            }
        }
        groundDrive.driveWithRaw(0, speed);
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        System.out.println("[FastTurnLeft] Ended");
    }
}
