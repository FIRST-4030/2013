package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 *
 * @author daboross
 */
public class FrisbeeDumperSolenoidRetract extends CommandBase {

    private boolean isFinished;

    public FrisbeeDumperSolenoidRetract() {
        requires(frisbeeDumperSolenoids);
    }

    protected void initialize() {
        isFinished = false;
    }

    protected void execute() {
        frisbeeDumperSolenoids.retract();
        RobotDebugger.push(frisbeeDumperSolenoids);
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
