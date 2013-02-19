package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.Message;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.subsystems.GroundDrive;
import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * Main Robot Class. This is the main Robot Class.
 */
public class RobotMain extends IterativeRobot {

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
        System.out.println("Robot Ready!");
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
        GroundDrive.disabled();
    }

    public void disabledInit() {
        DashboardStore.reInit();
        RobotDebugger.clearMap();
        for (int i = 0; i < list.length; i++) {
            list[i].disable();
        }
    }
    private static DisableNotifable[] list = new DisableNotifable[0];

    public static void addDisableNotifable(DisableNotifable d) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == d) {
                return;
            }
        }
        DisableNotifable[] temp = new DisableNotifable[list.length + 1];
        System.arraycopy(list, 0, temp, 0, list.length);
        temp[list.length] = d;
        list = temp;
    }
}
