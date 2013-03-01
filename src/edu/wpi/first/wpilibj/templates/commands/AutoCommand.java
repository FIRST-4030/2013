package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 * Autonomous Command.
 *
 * @author daboross
 */
public class AutoCommand extends CommandBase implements Debuggable {

    /**
     * This is how long the robot will wait from start of command before first
     * shoot.
     */
    private static final long timeFromStartupToShoot = 500;
    /**
     * This is how long the shooter is retracting the solenoid before it extends
     * it again.
     */
    private static final long timeForSolenoidToExtend = 50;
    /**
     * This is how long the robot should wait after shooting once before
     * shooting again (in milliseconds). This should be at least twice as big as
     * timeForSolenoidToExtend.
     */
    private static final long timeBetweenShots = 50;
    /**
     * This is how many shots before the robot stops shooting.
     */
    private static final int maxShots = 3;
    private boolean isFinished = false;
    /**
     * 0 is just started.
     *
     * 1 is shooter charged.
     *
     * 2 is shooting.
     *
     * 3 is done shooting.
     */
    private int state = -1;
    /**
     * This is when the command start (in milliseconds since robot booted up).
     */
    private long startTime;
    /**
     * This is the start time when the robot last shot.
     */
    private long lastShootTime;
    /**
     * This is how many times the robot has shot.
     */
    private int shotsShot = 0;

    private String getReadableState() {
        if (state == -1) {
            return "Not Run Yet";
        } else if (state == 0) {
            return "Speeding Up";
        } else if (state == 1) {
            return "Shooter Charged";
        } else if (state == 2) {
            return "Shooting";
        } else if (state == 3) {
            return "Done";
        } else {
            return "\"" + state + "\"";
        }
    }

    private long getTimeTillNextAction() {
        if (state == -1) {
            return -1;
        } else if (state == 0) {
            return (startTime + timeFromStartupToShoot) - System.currentTimeMillis();
        } else if (state == 1) {
            if (shotsShot == 0) {
                return 0;
            } else {
                return (lastShootTime + timeBetweenShots) - System.currentTimeMillis();
            }
        } else if (state == 2) {
            return (lastShootTime + timeForSolenoidToExtend) - System.currentTimeMillis();
        } else if (state == 3) {
            return -1;
        }
        return 0;
    }

    private boolean readyForNextAction() {
        return getTimeTillNextAction() <= 0;
    }

    public AutoCommand() {
        requires(groundDrive);
        requires(shooterMotors);
        requires(shooterSolenoids);
    }

    protected void initialize() {
        setState(0);
        groundDrive.stop();
        shooterSolenoids.extend();
        shooterMotors.setSpeed(1.0);
    }

    protected void execute() {
        if (state == -1) {
            throw new Error("STATE IS -1");
        } else if (state == 0) {
            if (readyForNextAction()) {
                setState(1);
            }
        } else if (state == 1) {
            shooterSolenoids.retract();
            if (readyForNextAction()) {
                setState(2);
            }
        } else if (state == 2) {
            if (readyForNextAction()) {
                if (shotsShot >= maxShots) {
                    setState(3);
                } else {
                    setState(1);
                }
            } else {
                shooterSolenoids.extend();
            }
        } else if (state == 3) {
            shooterSolenoids.retract();
            isFinished = true;
        }
        RobotDebugger.push(this);
    }

    /**
     * Sets the state variable, as well as does some changes to other variables
     * according to which state. if(state==0)
     * startTime=System.currentTimeMillis();
     * if(state==1)lastShootTime=System.currentTimeMillis();
     * if(state==2)shotsShot++; if(state==3)shooterSolenoids.retract();
     */
    private void setState(int state) {
        if (state < 0 || state > 3) {
            throw new IllegalArgumentException("Invalid State");
        }
        if (state == 0) {
            startTime = System.currentTimeMillis();
        } else if (state == 1) {
            lastShootTime = System.currentTimeMillis();
        } else if (state == 2) {
            shotsShot++;
        } else if (state == 3) {
            shooterSolenoids.retract();
        }
        this.state = state;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }

    public DebugOutput getStatus() {
        return new DebugInfoGroup(new DebugInfo[]{
            new InfoState("AutoCommand", getReadableState(), DebugLevel.ALWAYS),
            new DebugStatus("AutoCommand:TimeTillNextAction", getTimeTillNextAction(), DebugLevel.ALWAYS)});
    }
}