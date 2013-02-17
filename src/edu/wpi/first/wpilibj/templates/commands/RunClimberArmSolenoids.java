package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.variablestores.DashboardStore;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 *
 * @author daboross
 */
public class RunClimberArmSolenoids extends CommandBase {

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
                climberArmSolenoids.retract();
            } else {
                if (on) {
                    climberArmSolenoids.extendSlow();
                } else {
                    climberArmSolenoids.release();
                }
            }
        } else {
            climberArmSolenoids.retract();
        }
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}
