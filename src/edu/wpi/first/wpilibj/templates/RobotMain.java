package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
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
        //Tell the person on the Console/SmartDashboard what ports things should be.
        RobotDebugger.push(new DebugStatus("Port Of Left Motor", VstM.PWM.LEFT_MOTOR_PORT));
        RobotDebugger.push(new DebugStatus("Port Of Right Motor", VstM.PWM.RIGHT_MOTOR_PORT));
        RobotDebugger.push(new DebugStatus("Port Of Tower Motor", VstM.PWM.CLIMBER_MOTOR_PORT));
        RobotDebugger.push(new DebugStatus("Port Of First Shooter Motor", VstM.PWM.FIRST_SHOOTER_MOTOR_PORT));
        RobotDebugger.push(new DebugStatus("Port Of Second Shooter Motor", VstM.PWM.SECOND_SHOOTER_MOTOR_PORT));
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
    }
}
