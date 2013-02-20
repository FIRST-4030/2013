package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.DisableNotifable;
import edu.wpi.first.wpilibj.templates.RobotMain;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.variablestores.ClimberStore;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * This Command runs the climber motors with a joystick.
 */
public class RunClimber extends CommandBase implements Debuggable, DisableNotifable {

    /**
     * Climber state.
     *
     * 0 for not enabled, and in correct position.
     *
     * 1 for not enabled, and in wrong position.
     *
     * 2 for enabled, but not at correct position.
     *
     * 3 for enabled, and in correct position.
     */
    private int state = 0;
    private double speed = 0;
    private boolean lowerPressed;
    private boolean upperPressed;
    private boolean deployPressed;

    public RunClimber() {
        requires(climber);
        requires(climberLimitSwitch);
    }

    protected void initialize() {
        RobotMain.addDisableNotifable(this);
        climber.stop();
    }

    protected void execute() {
        checkLimitSwitches();
        stateCheck();
        driverSpeedChange();
        runClimberWithManSpeed();
        RobotDebugger.push(this);
        RobotDebugger.push(climber);
        RobotDebugger.push(climberLimitSwitch);
    }

    private void runClimberWithManSpeed() {
        climber.runLadder(speed);
    }

    private void driverSpeedChange() {
        if (ClimberStore.climberEnabled) {
            speed = VstJ.getLadderControlAxisValue();
            if (upperPressed && speed > 0) {
                speed = 0;
            }
            if (lowerPressed && speed < 0) {
                speed = 0;
            }
        } else {
            speed = 0;
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        climber.stop();
        speed = 0;
        RobotDebugger.push(this);
        RobotDebugger.push(climber);
        RobotDebugger.push(climberLimitSwitch);

    }

    private void checkLimitSwitches() {
        upperPressed = climberLimitSwitch.readUpper();
        lowerPressed = climberLimitSwitch.readLower();
        deployPressed = climberLimitSwitch.readDeploy();
    }

    private void stateCheck() {
        if (ClimberStore.climberEnabled) {
            if (state == 0) {
                state = 2;
            } else if (state == 1 && !deployPressed) {
                state = 2;
            }
        }
    }

    public void disable() {
        speed = 0;
        RobotDebugger.push(this);
        RobotDebugger.push(climber);
        RobotDebugger.push(climberLimitSwitch);
    }

    public DebugOutput getStatus() {
        DebugInfo[] infoList = new DebugInfo[2];
        infoList[0] = new InfoState("Climber:Enabled", DashboardStore.getIsClimberEnabled() ? "Yes" : "No", DebugLevel.HIGHEST);
        infoList[1] = new DebugStatus("Climber:SetSpeed", speed, DebugLevel.LOW);
        return new DebugInfoGroup(infoList);
    }
}
