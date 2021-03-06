package org.ingrahamrobotics.robot2013.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.ingrahamrobotics.robot2013.dashboardrelations.DashboardStore;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstAutoCommand;
//import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstClimber;

/**
 * Command to refresh values on and from the SmartDashboard.
 */
public class DashboardValueRefresh extends CommandBase {

    public DashboardValueRefresh() {
        SmartDashboard.putString("TimeUpdate", "-42");
    }

    protected void initialize() {
    }

    protected void execute() {
        SmartDashboard.putString("TimeUpdate", String.valueOf(System.currentTimeMillis()));
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
