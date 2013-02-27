package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 *
 * @author daboross
 */
public class RunClimberWedgeSolenoid extends CommandBase implements Debuggable {

    /**
     * -1 for retract, 0 for stay, 1 for extend.
     */
    private int state;

    public RunClimberWedgeSolenoid() {
        requires(climberWedgeSolenoid);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (DashboardStore.getIsClimberEnabled()) {
            double controlValue = VstJ.getClimberWedgeSolenoidControlAxisValue();
            if (controlValue < -0.5) {
                state = -1;
            } else if (controlValue > 0.5) {
                state = 1;
            } else {
                state = 0;
            }
            if (state == 1) {
                climberWedgeSolenoid.extend();
            } else if (state == -1) {
                climberWedgeSolenoid.retract();
            }
        } else {
            climberWedgeSolenoid.retract();
        }
        RobotDebugger.push(climberWedgeSolenoid);
        RobotDebugger.push(this);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    public DebugOutput getStatus() {
        return new InfoState("RunClimberWedge", getStateMessage(), DebugLevel.HIGH);
    }

    private String getStateMessage() {
        if (state == -1) {
            return "Retract";
        } else if (state == 1) {
            return "Extend";
        } else {
            return "Stay Put";
        }
    }
}
