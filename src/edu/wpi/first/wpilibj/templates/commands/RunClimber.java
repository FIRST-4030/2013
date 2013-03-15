package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.DisableNotifable;
import edu.wpi.first.wpilibj.templates.RobotMain;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

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
        if (DVstClimber.climberEnabled()) {
            climber.runLadder(VstJ.getLadderControlAxisValue() * speedMultiplier);
        } else {
            climber.runLadder(0);
        }
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
