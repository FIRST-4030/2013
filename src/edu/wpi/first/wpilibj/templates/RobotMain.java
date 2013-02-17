package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.Message;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * Main Robot Class.
 */
public class RobotMain extends IterativeRobot {

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
        pushPorts();
    }

    private void pushPorts() {
        //Tell the person on the Console/SmartDashboard what ports things should be.
        String info = "Port Info: ";
        info += ("LeftMotor:" + VstM.PWM.LEFT_MOTOR_PORT + " - ");
        info += ("RightMotor:" + VstM.PWM.RIGHT_MOTOR_PORT + " - ");
        info += ("ClimberMotor:" + VstM.PWM.CLIMBER_MOTOR_PORT + " - ");
        info += ("FirstShooterMotor:" + VstM.PWM.FIRST_SHOOTER_MOTOR_PORT + " - ");
        info += ("SecondShooterMotor:" + VstM.PWM.SECOND_SHOOTER_MOTOR_PORT + " - ");
        info += ("ClimberBottomSwitch:" + VstM.Relays.CLIMBER_LOWER_LIMIT_SWITCH + " - ");
        info += ("ClimberTopSwitch:" + VstM.Relays.CLIMBER_UPPER_LIMIT_SWITCH + " - ");
        info += ("ShooterSoenoid1:" + VstM.Solenoids.SHOOTER_SOLENOID_SIDE_1 + " - ");
        info += ("ShooterSoenoid2:" + VstM.Solenoids.SHOOTER_SOLENOID_SIDE_2 + " - ");
        DebugInfo debugInfo = new Message(info);
        RobotDebugger.push(debugInfo);
    }

    public void autonomousInit() {
        ImageProcess ip = new ImageProcess();
        ip.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    }

    /**
     * This function is called periodically during operator control.
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void disabledPeriodic() {
    }

    public void disabledInit() {
        RobotDebugger.clearMap();
    }
}
