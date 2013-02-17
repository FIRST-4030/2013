package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.DashboardStore;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * This Command runs the climber motors (The ones powering the "cart" that goes
 * up/down the ladder) according to a set speed, that is increased/decreased
 * with buttons.
 *
 * Same kind of drive as RunShooterMotors, but with different buttons.
 */
public class RunClimber extends CommandBase implements Debuggable {

    public RunClimber() {
        requires(climber);
        DashboardStore.initClimber();
    }

    protected void initialize() {
        climber.stop();

    }
    private double speed = 0;
    private boolean extendButtonLastPressed = false;
    private boolean retractButtonLastPressed = false;

    protected void execute() {
        checkEnabled();
        if (isEnabled) {
            if (VstJ.getClimberExtendButtonValue() != extendButtonLastPressed) {
                if (!extendButtonLastPressed) {
                    if (speed + 0.1 < 1) {
                        speed += 0.1;
                    } else {
                        speed = 1;
                    }
                    extendButtonLastPressed = !extendButtonLastPressed;
                }
            }
            if (VstJ.getClimberRetractButtonValue() != retractButtonLastPressed) {
                if (!retractButtonLastPressed) {
                    if (speed - 0.1 > 0) {
                        speed -= 0.1;
                    } else {
                        speed = 0;
                    }
                }
                retractButtonLastPressed = !retractButtonLastPressed;
            }
        } else {
            speed = 0;
        }
        climber.runLadder(speed);
        RobotDebugger.push(this);
        RobotDebugger.push(climber);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        climber.stop();
        RobotDebugger.push(climber);
    }

    protected void interrupted() {
        this.end();
        isEnabled = false;
        RobotDebugger.push(this);
    }

    public DebugOutput getStatus() {
        DebugInfo[] infoList = new DebugInfo[2];
        infoList[0] = new InfoState("Climber", isEnabled() ? "Enabled" : "Disabled");
        infoList[1] = new DebugStatus("ClimberShouldBe", speed);
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
