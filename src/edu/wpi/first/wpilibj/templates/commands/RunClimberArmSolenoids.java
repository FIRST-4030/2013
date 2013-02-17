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
    private boolean pressedLast = false;
    private boolean on = false;
    private boolean justStarted = true;
    private String status = "No Status Set";

    protected void execute() {
        if (DashboardStore.getClimberEnabled()) {
            if (VstJ.getClimberArmSolenoidToggleButtonValue() != pressedLast) {
                justStarted = false;
                if (pressedLast) {
                    on = !on;
                }
                pressedLast = !pressedLast;
            }
            if (justStarted) {
                status = "Just Started";
                climberArmSolenoids.retract();
            } else {
                if (on) {
                    status = "ExtendSlow";
                    climberArmSolenoids.extendSlow();
                } else {
                    status = "release";
                    climberArmSolenoids.release();
                }
            }
        } else {
            status = "Not Enabled";
            climberArmSolenoids.retract();
        }
        RobotDebugger.push(climberArmSolenoids);
        RobotDebugger.push(this);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }

    public DebugOutput getStatus() {
        return new InfoState("RunClimberArmSolenoid", status);
    }
}
