package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * This Command runs the Climber out-pushing solenoid from input received from
 * VstJ.getClimberArmSolenoidToggleButtonValue(), as well as
 * DashboardStore.getClimberEnabled().
 */
public class RunClimberArmSolenoids extends CommandBase implements Debuggable {

    private boolean extending = false;
    private String status = "No Status Set";
    public RunClimberArmSolenoids() {
        requires(climberArmSolenoids);
    }

    protected void initialize() {
        System.out.println("RunClimber: Init");
        climberArmSolenoids.retract();
    }

    protected void execute() {
        /**
         * Basically this is saying, if the climber is disabled then set the
         * state to retract. If the climber is enabled, then look for the button
         * press. The first time the button is pressed after the climber is
         * enabled the solenoid will go into slow extend mode, and stay in that
         * mode until the climber is disabled.
         *
         * NOTE: When I say Climber Enabled or Climber Disabled, I am talking
         * about a setting in the SmartDashboard.
         */
        if (DVstClimber.climberEnabled()) {
            if (!extending) {
                status = "Just Started";
            }
            if (VstJ.getClimberArmStartToggleButtonValue()) {
                extending = true;
            }
        } else {
            status = "Disabled";
            extending = false;
        }
        if (extending) {
            status = "Extending";
            climberArmSolenoids.extend();
        } else {
            status = "Not Extending";
            climberArmSolenoids.retract();
        }
        RobotDebugger.push(climberArmSolenoids);
        RobotDebugger.push(this);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    public DebugOutput getStatus() {
        return new InfoState("RunClimberArmSolenoid", status, DebugLevel.HIGH);
    }
}
