package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * Run Frisbee dumper (For top of pyramid).
 *
 * @author daboross
 */
public class RunFrisbeeDumperSolenoid extends CommandBase implements Debuggable {

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
        RobotDebugger.push(this);
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    public DebugOutput getStatus() {
        return new InfoState("RunFrisbeeDumper", done ? "Extending" : "Not Extending", DebugLevel.HIGH);
    }
}
