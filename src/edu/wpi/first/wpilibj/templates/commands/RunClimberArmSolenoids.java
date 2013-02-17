package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.DashboardStore;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 *
 * @author daboross
 */
public class RunClimberArmSolenoids extends CommandBase implements Debuggable {

    public RunClimberArmSolenoids() {
        DashboardStore.initClimber();
        requires(climberArmSolenoids);
    }

    protected void initialize() {
        climberArmSolenoids.retract();
    }
    private boolean extending = false;
    private String status = "No Status Set";

    protected void execute() {
        if (DashboardStore.getClimberEnabled()) {
            if (VstJ.getClimberArmSolenoidToggleButtonValue()) {
                extending = true;
            }
            if (!extending) {
                status = "Just Started";
            }
        } else {
            status = "Not Enabled";
            extending = false;
        }
        if (extending) {
            status = "Extending";
            climberArmSolenoids.extend();
        } else {
            climberArmSolenoids.retract();
        }
        RobotDebugger.push(climberArmSolenoids);
        RobotDebugger.push(this);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        climberArmSolenoids.retract();
    }

    protected void interrupted() {
        end();
    }

    public DebugOutput getStatus() {
        return new InfoState("RunClimberArmSolenoid", status);
    }
}
