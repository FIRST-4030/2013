package edu.wpi.first.wpilibj.templates.unused;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * Run Frisbee dumper (For top of pyramid).
 *
 * @author daboross
 */
public class OldRunFrisbeeDumperSolenoid extends CommandBase {

    public OldRunFrisbeeDumperSolenoid() {
        requires(frisbeeDumperSolenoids);
    }

    protected void initialize() {
        frisbeeDumperSolenoids.extend();
        RobotDebugger.push(frisbeeDumperSolenoids);
    }

    protected void execute() {
        if (DVstClimber.climberEnabled()) {
            if (VstJ.getFrisbeeDumpButton().get()) {
                frisbeeDumperSolenoids.retract();
            } else if (VstJ.getFrisbeeUnDumpButton().get()) {
                frisbeeDumperSolenoids.extend();
            }
        }
        RobotDebugger.push(frisbeeDumperSolenoids);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
}
