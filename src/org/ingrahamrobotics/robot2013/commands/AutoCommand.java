package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.DebugOutput;
import org.ingrahamrobotics.robot2013.debugging.Debuggable;
import org.ingrahamrobotics.robot2013.debugging.infos.InfoState;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstAutoCommand;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstPressure;

/**
 * Autonomous Command.
 */
public class AutoCommand extends CommandBase implements Debuggable {

    /**
     * This is how long the robot should keep the solenoid extended before
     * retracting it again (In milliseconds).
     */
    private static final long timeSolenoidExtendedMillis = 500;
    /**
     * This is how long the robot should keep the solenoid retracted before
     * extending it again (In milliseconds).
     */
    private static final long timeSolenoidRetractedMillis = 1000;
    /**
     * This is the minimum amount of time the robot will wait before shooting
     * first time (In milliseconds).
     */
    private static final long timeTillFirstMillis = 5000;
    /**
     * This is the maximum amount of time the robot will wait before shooting
     * first time (In milliseconds).
     */
    private long maxWaitTimeMillis = DVstAutoCommand.getAutoCommandWaitTime();
    /**
     * 0 is just started.
     *
     * 1 is solenoid retracted.
     *
     * 2 is solenoid extended.
     */
    private int state = 0;
    /**
     * This is the start time when the robot last changed state (Extended or
     * Retracted the solenoid).
     */
    private long lastStateChangeTime;
    private long startTime;

    /**
     * @return A string that represents the state of AutoCommand.
     */
    private String getReadableState() {
        if (state == 0) {
            return "Speeding Up";
        } else if (state == 1) {
            return "Solenoid Retracting";
        } else if (state == 2) {
            return "Solenoid Extending";
        } else {
            return "?\"" + state + "\"?";
        }
    }

    /**
     * First check if the minimum time before shooting has passed. If it hasn't,
     * then return false. Otherwise, if the maximum time has passed, return
     * true. Otherwise, if the time is at least minimum and not yet maximum
     * waiting time, return whether or not the compression system is at
     * pressure.
     */
    private boolean isReadyToShoot() {
        long timeSinceStart = System.currentTimeMillis() - startTime;
        return (timeSinceStart < timeTillFirstMillis) ? false : ((timeSinceStart > maxWaitTimeMillis) ? true : DVstPressure.atPressure());
    }

    /**
     * @return if this command is ready to change to the next state.
     */
    private boolean readyForNextAction() {
        if (state == 0) {
            return isReadyToShoot();
        } else if (state == 1) {
            return System.currentTimeMillis() - lastStateChangeTime >= timeSolenoidRetractedMillis;
        } else if (state == 2) {
            return System.currentTimeMillis() - lastStateChangeTime >= timeSolenoidExtendedMillis;
        }
        System.out.println("[AutoCommand] readyForNextAction() called while state is " + state);
        return true;
    }

    /**
     * Default Constructor
     */
    public AutoCommand() {
        requires(groundDrive);
        requires(shooterMotors);
        requires(shooterSolenoids);
    }

    /**
     * Re-initializes this command.
     */
    public void reInitValues() {
        initialize();
    }

    /**
     * Initializes this command. (Preparation for execute())
     */
    protected void initialize() {
        setState(0);
        groundDrive.stop();
        shooterSolenoids.extend();
        dVstShooterMotors.turnOn();
    }

    /**
     * Execute this command. (Called multiple times through execution)
     */
    protected void execute() {
        maxWaitTimeMillis = DVstAutoCommand.getAutoCommandWaitTime();
        if (state == 0) {
            if (readyForNextAction()) {
                setState(1);
            }
        } else if (state == 1) {
            if (readyForNextAction()) {
                setState(2);
            }
        } else if (state == 2) {
            if (readyForNextAction()) {
                setState(1);
            }
        }
    }

    /**
     * Sets the state variable, as well as does some changes to other variables
     * according to which state. This calls shooterSolenoids.retract() if
     * setState is 1, and shooterSolenoids.extend() if setState is 2. This also
     * calls RobotDebugger.push(this).
     */
    private void setState(int setState) {
        if (setState == 0) {
            startTime = System.currentTimeMillis();
        } else if (setState == 1) {
            lastStateChangeTime = System.currentTimeMillis();
            shooterSolenoids.retract();
        } else if (setState == 2) {
            lastStateChangeTime = System.currentTimeMillis();
            shooterSolenoids.extend();
        } else {
            throw new IllegalArgumentException("Invalid State");
        }
        this.state = setState;
        RobotDebugger.push(this);
    }

    /**
     * @return whether or not this command is finished.
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Ends this command (Called after isFinished returns true)
     */
    protected void end() {
        dVstShooterMotors.turnOff();
        setState(0);
    }

    /**
     * @return Gets a DebugOutput representing the status of this command.
     */
    public DebugOutput getStatus() {
        return new InfoState("AutoCommand", getReadableState(), DebugLevel.HIGH);
    }
}
