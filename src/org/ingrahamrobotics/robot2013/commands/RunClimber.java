package org.ingrahamrobotics.robot2013.commands;

import org.ingrahamrobotics.robot2013.DisableNotifable;
import org.ingrahamrobotics.robot2013.RobotMain;
import org.ingrahamrobotics.robot2013.dashboardrelations.DashboardStore;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.DebugOutput;
import org.ingrahamrobotics.robot2013.debugging.infos.DebugStatus;
import org.ingrahamrobotics.robot2013.debugging.Debuggable;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.vstj.VstJ;

/**
 * This Command runs the climber motors with a joystick.
 */
public class RunClimber extends CommandBase implements Debuggable, DisableNotifable {

    private double speedMultiplier = 1;

    public RunClimber() {
        requires(climber);
    }

    protected void initialize() {
        RobotMain.addDisableNotifable(this);
        climber.stop();
    }

    protected void execute() {
        speedMultiplier = DashboardStore.getClimberSpeedMultiplier();
        climber.runLadder(VstJ.getLadderControlAxisValue() * speedMultiplier);
        RobotDebugger.push(this);
        RobotDebugger.push(climber);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        climber.stop();
        RobotDebugger.push(this);
        RobotDebugger.push(climber);

    }

    public void disable() {
        climber.stop();
        RobotDebugger.push(this);
        RobotDebugger.push(climber);
    }

    public DebugOutput getStatus() {
        return new DebugStatus("Climber:Speed-Multiplier", speedMultiplier, DebugLevel.HIGHEST);
    }
}
