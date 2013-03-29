package edu.wpi.first.wpilibj.templates.dashboardrelations;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 * This is a variable store that stores values that are on the SmartDashboard.
 * Each time you ask for one it will check the SmartDashboard and return you the
 * value the SmartDashboard gives it.
 *
 * @author daboross
 */
public final class DashboardStore {

    private static final BooleanDashObject isClimberEnabledObject;
    /**
     * False is left, true is right.
     */
    private static final BooleanDashObject cameraPosition;

    static {
        isClimberEnabledObject = new BooleanDashObject("aIsClimberEnabled", "Enable Climber", "Disable Climber", false);
        cameraPosition = new BooleanDashObject("aCameraPosition", "Camera Left", "Camera Right", true);
    }

    public static double getClimberSpeedMultiplier() {
        return SmartDashboard.getNumber("Climber Speed Multiplier Setter");
    }

    public static double getShooterMotor1SpeedMultiplier() {
        return SmartDashboard.getNumber("Shooter Motor Speed 1 Multiplier Setter");
    }

    public static double getShooterMotor2SpeedMultiplier() {
        return SmartDashboard.getNumber("Shooter Motor Speed 2 Multiplier Setter");
    }

    public static int getAutoCommandTimeout() {
        return (int) (SmartDashboard.getNumber("Auto Command Max Wait Time Setter") * 1000);
    }

    public static boolean getIsClimberEnabled() {
        final boolean enabledGet = isClimberEnabledObject.getValue();
        RobotDebugger.push(new InfoState("Climber:Enabled", enabledGet ? "Yes" : "No", DebugLevel.HIGHEST));
        return enabledGet;
    }

    /**
     * True for left, False for right.
     */
    public static boolean getCameraPosition() {
        final boolean enabledGet = cameraPosition.getValue();
        RobotDebugger.push(new InfoState("Camera:Position", enabledGet ? "Camera Left" : "Camera Right", DebugLevel.HIGHEST));
        return enabledGet;
    }

    public static void reCreate() {
        cameraPosition.reCreate();
        isClimberEnabledObject.reCreate();
        double autoSpeed;
        try {
            autoSpeed = SmartDashboard.getNumber("Auto Command Max Wait Time Setter");
        } catch (TableKeyNotDefinedException tknde) {
            autoSpeed = 0;
        }
        if (autoSpeed == 0) {
            SmartDashboard.putNumber("Auto Command Max Wait Time Setter", autoSpeed);
        }
    }
}
