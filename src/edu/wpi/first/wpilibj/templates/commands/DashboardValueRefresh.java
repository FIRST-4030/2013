package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstCamera;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;

/**
 *
 * @author daboross
 */
public class DashboardValueRefresh extends CommandBase {

    public DashboardValueRefresh() {
    }

    protected void initialize() {
    }

    protected void execute() {
        DashboardStore.checkDebugLevelChanger();
        SmartDashboard.putString("TimeUpdate", String.valueOf(System.currentTimeMillis()));
        DVstCamera.setCameraPosition(DashboardStore.getCameraPosition());
        DVstClimber.setClimberEnabled(DashboardStore.getIsClimberEnabled());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        SmartDashboard.putString("TimeUpdate", "Disabled!!!");
    }
}
