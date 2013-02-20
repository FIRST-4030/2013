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
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstC;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * This Command runs the climber motors with a joystick.
 */
public class RunClimber extends CommandBase implements Debuggable, DisableNotifable {

    /**
     * Climber state.
     *
     * 0 for disabled, and in correct position.
     *
     * 1 for disabled, and moving up.
     *
     * 2 for enabled, and moving down.
     *
     * 3 for enabled, and moving up.
     *
     * 4 for enabled, and in correct position.
     *
     * 5 for solenoid extended.
     */
    private int state = 0;
    private double speedMultiplier = 1;

    private String getStateName() {
        if (state == 0) {
            return "Climber Disabled, Not Moving";
        } else if (state == 1) {
            return "Climber Disabled, Auto-Moving Up";
        } else if (state == 2) {
            return "Climber Enabled, Auto-Moving Down";
        } else if (state == 3) {
            return "Climber Enabled, Auto-Moving Up";
        } else if (state == 4) {
            return "Climber Enabled, Not Auto-Moving";
        } else if (state == 5) {
            return "Solenoid Extended, Auto-Move Disabled";
        } else {
            return state + " Is Unknown (BAD)";
        }
    }

    private boolean isDisabledState() {
        return state == 0 || state == 1;
    }
    private double speed = 0;

    public RunClimber() {
        requires(climber);
    }

    protected void initialize() {
        RobotMain.addDisableNotifable(this);
        climber.stop();
    }

    protected void execute() {
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
        speedMultiplier = DashboardStore.getClimberSpeedMultiplier();
        if (DVstC.climberEnabled()) {
            speed = VstJ.getLadderControlAxisValue() * speedMultiplier;
            if (DVstC.LimitSwitches.upper() && speed > 0) {
                speed = 0;
            }
            if (DVstC.LimitSwitches.lower() && speed < 0) {
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

    private void stateCheck() {
        if (DVstC.climberArmExtending()) {
        } else {
            if (DVstC.climberEnabled()) {
                if (isDisabledState()) {
                    if (DVstC.LimitSwitches.deploy() || DVstC.LimitSwitches.upper()) {
                        state = 2;
                    } else {
                        state = 3;
                    }
                }
                if (state == 2 && !DVstC.LimitSwitches.deploy() && !DVstC.LimitSwitches.upper()) {
                    state = 4;
                }
                if (DVstC.LimitSwitches.lower()) {
                    state = 3;
                }
            } else {
                if (DVstC.LimitSwitches.upper()) {
                    state = 0;
                } else {
                    state = 1;
                }
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
        DebugInfo[] infoList = new DebugInfo[4];
        infoList[0] = new InfoState("Climber:Enabled", DashboardStore.getIsClimberEnabled() ? "Yes" : "No", DebugLevel.HIGHEST);
        infoList[1] = new InfoState("Climber:AutoState", getStateName(), DebugLevel.HIGH);
        infoList[2] = new DebugStatus("Climber:SetSpeed", speed, DebugLevel.LOW);
        infoList[3] = new DebugStatus("Climber:Speed Multiplier", speedMultiplier, DebugLevel.HIGHEST);
        return new DebugInfoGroup(infoList);
    }
}
