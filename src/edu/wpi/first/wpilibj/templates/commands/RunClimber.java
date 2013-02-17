package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.DashboardStore;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 *
 */
public class RunClimber extends CommandBase implements Debuggable {

    public RunClimber() {
        requires(climber);
        DashboardStore.initClimber();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        climber.stop();

    }
    private double lastSpeed;

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        checkEnabled();
        if (isEnabled) {
            double climbSpeed = 0;
            if (VstJ.getClimberExtendButtonValue()) {
                climbSpeed += 1;
            }
            if (VstJ.getClimberRetractButtonValue()) {
                climbSpeed -= 1;
            }
            /*if (climbSpeed != 0) {
             if (((VstM.Climber.climberState() == -1) != (climbSpeed < 0))
             || ((VstM.Climber.climberState() == 1) != climbSpeed > 0)) {
             climbSpeed = VstM.Climber.climberState();
             }
             }*/
            climbSpeed *= 0.5;
            climber.runLadder(climbSpeed);
            lastSpeed = climbSpeed;
        } else {
            climber.runLadder(0);
            lastSpeed = 0;
        }
        RobotDebugger.push(climber);
        RobotDebugger.push(this);
    }
// Make this return true when this Command no longer needs to run execute()

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        climber.stop();
        RobotDebugger.push(climber);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
        isEnabled = false;
        RobotDebugger.push(this);
    }

    public DebugOutput getStatus() {
        DebugInfo[] infoList = new DebugInfo[2];
        infoList[0] = new InfoState("Climber", isEnabled() ? "Enabled" : "Disabled");
        infoList[1] = new DebugStatus("ClimberShould", lastSpeed);
        return new DebugInfoGroup(infoList);
    }
    private boolean isEnabled;

    private void checkEnabled() {
        isEnabled = DashboardStore.getClimberEnabled();
    }

    private boolean isEnabled() {
        return isEnabled;
    }
}
