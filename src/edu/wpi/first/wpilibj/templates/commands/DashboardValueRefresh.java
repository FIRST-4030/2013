package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 *
 * @author daboross
 */
public class DashboardValueRefresh extends CommandBase {

    public DashboardValueRefresh() {
        DashboardStore.reInit();
        DashboardStore.checkDebugLevelChanger();
    }

    protected void initialize() {
    }

    protected void execute() {
        DashboardStore.checkDebugLevelChanger();
        SmartDashboard.putNumber("TimeUpdate", System.currentTimeMillis());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}
