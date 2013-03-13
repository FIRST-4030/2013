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
public class OldRunFrisbeeDumperSolenoid extends CommandBase implements Debuggable {

    private String state = "Not Set";

    public OldRunFrisbeeDumperSolenoid() {
        requires(frisbeeDumperSolenoids);
    }

    protected void initialize() {
        frisbeeDumperSolenoids.expand();
        RobotDebugger.push(this);
    }

    protected void execute() {
        if (DVstClimber.climberEnabled()) {
            if (VstJ.getFrisbeeDumpButtonValue()) {
                frisbeeDumperSolenoids.retract();
                state = "Retracting";
            } else if (VstJ.getFrisbeeUnDumpButtonValue()) {
                frisbeeDumperSolenoids.expand();
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
