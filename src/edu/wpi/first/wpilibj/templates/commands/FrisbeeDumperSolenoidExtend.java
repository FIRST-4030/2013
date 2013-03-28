package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;

/**
 *
 * @author daboross
 */
public class FrisbeeDumperSolenoidExtend extends CommandBase {

    private boolean isFinished;

    public FrisbeeDumperSolenoidExtend() {
        requires(frisbeeDumperSolenoids);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        if (DVstClimber.climberEnabled()) {
            frisbeeDumperSolenoids.extend();
            RobotDebugger.push(frisbeeDumperSolenoids);
        }
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}