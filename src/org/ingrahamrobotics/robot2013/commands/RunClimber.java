package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.DisableNotifable;
import org.ingrahamrobotics.robot2013.RobotMain;
import org.ingrahamrobotics.robot2013.dashboardrelations.DashboardStore;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.vstj.VstJ;

/**
 * This Command runs the climberMotors motors with a joystick.
 */
public class RunClimber extends CommandBase implements DisableNotifable {

    private static final double DEFAULT_SPEED_MULTIPLIER = 0.5;
    private double speedMultiplier = DEFAULT_SPEED_MULTIPLIER;

    /**
     * Default Constructor
     */
    public RunClimber() {
        requires(climberMotors);
    }

    /**
     * Initializes this command. (Preparation for execute())
     */
    protected void initialize() {
        RobotMain.addDisableNotifable(this);
        climberMotors.stop();
    }

    /**
     * Execute this command. (Called multiple times through execution)
     */
    protected void execute() {
        speedMultiplier = DashboardStore.getClimberSpeedMultiplier();
        climberMotors.runLadder(VstJ.getLadderControlAxisValue() * speedMultiplier);
        this.outputStatus();
        climberMotors.outputStatus();
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
        climberMotors.stop();
        this.outputStatus();
        climberMotors.outputStatus();

    }

    /**
     * Runs actions that should be run when the robot is disabled. Mainly
     * turning off the climber motors
     */
    public void disable() {
        climberMotors.stop();
        this.outputStatus();
        climberMotors.outputStatus();
    }

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.HIGHEST, "Climber:Speed-Multiplier", speedMultiplier);
    }
}
