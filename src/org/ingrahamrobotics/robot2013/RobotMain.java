package org.ingrahamrobotics.robot2013;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.ingrahamrobotics.robot2013.commands.AutoCommand;
import org.ingrahamrobotics.robot2013.commands.CommandBase;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;

/**
 * Main Robot Class. This is the main Robot Class.
 */
public class RobotMain extends IterativeRobot {

    AutoCommand auto;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
        if (auto == null) {
            auto = new AutoCommand();
        }
        System.out.println("Robot Ready!");
    }

    public void autonomousInit() {
        if (auto == null) {
            auto = new AutoCommand();
        }
        auto.reInitValues();
        auto.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (auto != null) {
            auto.cancel();
        }
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }

    public void disabledPeriodic() {
    }

    public void disabledInit() {
        if (auto != null) {
            auto.cancel();
        }
        for (int i = 0; i < list.length; i++) {
            list[i].disable();
        }
        RobotDebugger.repushDashboard();
    }
    private static DisableNotifable[] list = new DisableNotifable[0];

    /**
     * Add a DisableNotifable to be notified when the robot is disabled. When
     * the robot is disabled RobotMain will go through these classes and run
     * each of their disable() methods.
     *
     * @param d The DisableNotifiable to notify.
     */
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
