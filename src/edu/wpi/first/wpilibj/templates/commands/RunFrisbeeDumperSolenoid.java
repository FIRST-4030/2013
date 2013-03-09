package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * Run Frisbee dumper (For top of pyramid).
 *
 * @author daboross
 */
public class RunFrisbeeDumperSolenoid extends CommandBase implements Debuggable {

    private String state = "Not Set";

    public RunFrisbeeDumperSolenoid() {
        requires(frisbeeDumperSolenoids);
    }

    protected void initialize() {
        frisbeeDumperSolenoids.startExpand();
        RobotDebugger.push(this);
    }

    protected void execute() {
        if (DVstClimber.climberEnabled()) {
            if (VstJ.getFrisbeeDumpButtonValue()) {
                frisbeeDumperSolenoids.startRetract();
                state = "Retracting";
            } else if (VstJ.getFrisbeeUnDumpButtonValue()) {
                frisbeeDumperSolenoids.startExpand();
                state = "Expanding";
            }
        } else {
            state = "Disabled";
        }
        RobotDebugger.push(this);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    public DebugOutput getStatus() {
        return new InfoState("FrisbeeDumperSolenoids:Should", state, DebugLevel.LOW);
    }
}
