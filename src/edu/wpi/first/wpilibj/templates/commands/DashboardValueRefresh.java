package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstAutoCommand;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstCamera;
//import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;

/**
 * Command to refresh values on and from the SmartDashboard.
 *
 * @author daboross
 */
public class DashboardValueRefresh extends CommandBase {

    public DashboardValueRefresh() {
        SmartDashboard.putString("TimeUpdate", "-42");
    }

    protected void initialize() {
    }

    protected void execute() {
        SmartDashboard.putString("TimeUpdate", String.valueOf(System.currentTimeMillis()));
        DVstCamera.setCameraPosition(DashboardStore.getCameraPosition());
//        DVstClimber.setClimberEnabled(DashboardStore.getIsClimberEnabled());
        DVstAutoCommand.setAutoCommandWaitTime(DashboardStore.getAutoCommandTimeout());
        dVstShooterMotors.setOnSpeed(DashboardStore.getShooterMotor1SpeedMultiplier(), DashboardStore.getShooterMotor2SpeedMultiplier());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        SmartDashboard.putString("TimeUpdate", "-42? (Not Good...)");
    }
}
