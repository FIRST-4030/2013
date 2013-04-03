package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
//import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;

/**
 * This Command runs the Climber out-pushing solenoid from input received from
 * VstJ.getClimberArmSolenoidToggleButtonValue(), as well as
 * DashboardStore.getClimberEnabled().
 */
public class ExtendClimberArmSolenoids extends CommandBase {

    private boolean isFinished;

    public ExtendClimberArmSolenoids() {
        requires(ladderPushSolenoids);
        RobotDebugger.push(ladderPushSolenoids);
    }

    protected void initialize() {
        isFinished = false;
    }

    /**
     * Basically this is saying, if the climber is disabled then set the state
     * to retract. If the climber is enabled, then look for the button press.
     * The first time the button is pressed after the climber is enabled the
     * solenoid will go into slow extend mode, and stay in that mode until the
     * climber is disabled.
     *
     * NOTE: When I say Climber Enabled or Climber Disabled, I am talking about
     * a setting in the SmartDashboard.
     */
    protected void execute() {
//        ladderPushSolenoids.extend();
//        RobotDebugger.push(ladderPushSolenoids);
        isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }
}
