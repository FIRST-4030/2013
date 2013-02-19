package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * Run Frisbee dumper (For top of pyramid).
 *
 * @author daboross
 */
public class RunFrisbeeDumperSolenoid extends CommandBase {

    private boolean done;

    public RunFrisbeeDumperSolenoid() {
        requires(frisbeeDumperSolenoid);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (VstJ.getFrisbeeDumpButtonValue() && DashboardStore.getIsClimberEnabled()) {
            frisbeeDumperSolenoid.startExpand();
            done = true;
        }
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }
}
