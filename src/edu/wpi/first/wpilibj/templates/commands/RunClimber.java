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
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * This Command runs the climber motors with a joystick.
 */
public class RunClimber extends CommandBase implements Debuggable, DisableNotifable {

    private boolean limitSwitchEnabled = true;
    private double speed = 0;
    private boolean lowerPressed;
    private boolean upperPressed;

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
        runClimber();
        RobotDebugger.push(this);
        RobotDebugger.push(climber);
        RobotDebugger.push(climberLimitSwitch);
    }

    private void runClimber() {
        if (DashboardStore.getIsClimberEnabled()) {
            setSpeedMan();
        } else {
            speed = 0;
        }
        climber.runLadder(speed);
    }

    private void setSpeedMan() {
        speed = VstJ.getLadderControlAxisValue();
        if (upperPressed && speed > 0) {
            speed = 0;
        }
        if (lowerPressed && speed < 0) {
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
        if (limitSwitchEnabled) {
            upperPressed = climberLimitSwitch.readUpper();
            lowerPressed = climberLimitSwitch.readLower();
        } else {
            upperPressed = false;
            lowerPressed = false;
        }
    }

    public DebugOutput getStatus() {
        DebugInfo[] infoList = new DebugInfo[3];
        infoList[0] = new InfoState("Climber:Enabled", DashboardStore.getIsClimberEnabled() ? "Yes" : "No", DebugLevel.HIGHEST);
        infoList[1] = new DebugStatus("Climber:SetSpeed", speed, DebugLevel.LOW);
        infoList[2] = new DebugStatus("ClimberLimitSwitch:Enabled", limitSwitchEnabled, DebugLevel.LOW);
        return new DebugInfoGroup(infoList);
    }

    public void disable() {
        speed = 0;
        RobotDebugger.push(this);
        RobotDebugger.push(climber);
        RobotDebugger.push(climberLimitSwitch);
    }
}
