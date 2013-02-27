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

    private boolean extending;

    public RunClimberWedgeSolenoid() {
        requires(climberWedgeSolenoids);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (DashboardStore.getIsClimberEnabled()) {
            double controlValue = VstJ.getClimberWedgeSolenoidControlAxisValue();
            if (controlValue < -0.5) {
                extending = true;
            } else if (controlValue > 0.5) {
                extending = false;
            } else {
            }
            if (extending) {
                climberWedgeSolenoids.extend();
            } else {

                climberWedgeSolenoids.retract();
            }
        } else {
            extending = false;
            climberWedgeSolenoids.retract();
        }
        RobotDebugger.push(climberWedgeSolenoids);
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
        return extending ? "Extending" : "Retracting";
    }
}
