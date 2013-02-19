package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;

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
        SmartDashboard.putString("TimeUpdate", String.valueOf(System.currentTimeMillis()));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        SmartDashboard.putString("TimeUpdate", "Disabled!!!");
    }
}
