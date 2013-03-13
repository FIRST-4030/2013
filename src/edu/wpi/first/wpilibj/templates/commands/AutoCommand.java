package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstP;

/**
 * Autonomous Command.
 *
 * @author daboross
 */
public class AutoCommand extends CommandBase implements Debuggable {

    /**
     * This is how long the shooter is retracting the solenoid before it extends
     * it again.
     */
    private static final long timeForSolenoidToExtend = 500;
    /**
     * This is how long the robot should wait after shooting once before
     * shooting again (in milliseconds). This should be at least twice as big as
     * timeForSolenoidToExtend.
     */
    private static final long timeBetweenShots = 1000;
    private static final long timeTillFirst = 5000;
    private static final long maxWaitTime = 10000;
    private boolean isFinished = false;
    /**
     * 0 is just started.
     *
     * 1 is shooter charged.
     *
     * 2 is shooting/solenoid extending.
     */
    private int state = 0;
    /**
     * This is the start time when the robot last shot.
     */
    private long lastShootTime;
    private long startTime;
    private int numberOfTimesDVstPAtPressure;

    private String getReadableState() {
        if (state == -1) {
            return "Not Run Yet";
        } else if (state == 0) {
            return "Speeding Up";
        } else if (state == 1) {
            return "Shooter Charged";
        } else if (state == 2) {
            return "Solenoid Extending";
        } else {
            return "\"" + state + "\"";
        }
    }

    private boolean readyToShoot() {
        if (DVstP.atPressure()) {
            numberOfTimesDVstPAtPressure++;
        }
        long now = System.currentTimeMillis();
        return (now > startTime + maxWaitTime) ? true : ((now < startTime + timeTillFirst) ? false : (numberOfTimesDVstPAtPressure > 2));
    }

    private long getTimeTillNextAction() {
        if (state == -1) {
            return -1;
        } else if (state == 0) {
            return readyToShoot() ? 0 : 42;
        } else if (state == 1) {
            return (lastShootTime + timeBetweenShots) - System.currentTimeMillis();
        } else if (state == 2) {
            return (lastShootTime + timeForSolenoidToExtend) - System.currentTimeMillis();
        }
        return -1;
    }

    private boolean readyForNextAction() {
        return getTimeTillNextAction() <= 0;
    }

    public AutoCommand() {
        requires(groundDrive);
        requires(shooterMotors);
        requires(shooterSolenoids);
    }

    public void newValues() {
        initialize();
    }

    protected void initialize() {
        startTime = System.currentTimeMillis();
        setState(0);
        numberOfTimesDVstPAtPressure = 0;
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
            if (readyForNextAction()) {
                setState(2);
            } else {
                shooterSolenoids.retract();
            }
        } else if (state == 2) {
            if (readyForNextAction()) {
                setState(1);
            } else {
                shooterSolenoids.extend();
            }
        }
        RobotDebugger.push(this);
    }

    /**
     * Sets the state variable, as well as does some changes to other variables
     * according to which state.
     * if(state==1)lastShootTime=System.currentTimeMillis();
     * if(state==2)shotsShot++;
     */
    private void setState(int state) {
        if (state < 0 || state > 2) {
            throw new IllegalArgumentException("Invalid State");
        }
        if (state == 0) {
        } else if (state == 1) {
            lastShootTime = System.currentTimeMillis();
        } else if (state == 2) {
            lastShootTime = System.currentTimeMillis();
        } else {
            System.out.println("INVALID STATE IN AUTO COMMAND!");
            return;
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