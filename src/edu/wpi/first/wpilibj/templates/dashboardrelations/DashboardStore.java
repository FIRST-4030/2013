package edu.wpi.first.wpilibj.templates.dashboardrelations;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    
    private static BooleanDashObject isClimberEnabledObject;
    private static BooleanDashObject cameraPosition;//False is left, true is right.
    private static IntegerDashObject debugLevelChanger;

    /**
     * Carriage
     */
    static {
        isClimberEnabledObject = new BooleanDashObject("-IsClimberEnabled", "Enable Climber", "Disable Climber", false);
        debugLevelChanger = new IntegerDashObject("-DebugLevelChanger", new String[]{"All Messages", "Lowest or Higher", "Low or Higher", "Mid or Higher", "High or Higher", "Highest or Higher", "Only \"Always\" messages"}, 6);
        cameraPosition = new BooleanDashObject("-CameraPosition", "Camera Left", "Camera Right", true);
        SmartDashboard.putNumber("Climber Speed Multiplier", 1.0);
    }
    
    public static double getClimberSpeedMultiplier() {
        return SmartDashboard.getNumber("Climber Speed Multiplier");
    }
    
    public static boolean getIsClimberEnabled() {
        return isClimberEnabledObject.getValue();
    }

    /**
     * True for left, False for right.
     */
    public static boolean getCameraPosition() {
        return cameraPosition.getValue();
    }
    
    private static int getDebugLevelChanger() {
        return debugLevelChanger.getValue();
    }
    
    public static void checkDebugLevelChanger() {
        int debugLevelChange = getDebugLevelChanger();
        if (debugLevelChange < DebugLevel.CURRENT) {
            DebugLevel.CURRENT = debugLevelChange;
        }
        RobotDebugger.push(new InfoState("Debug To Show:", DebugLevel.getNameOf(DebugLevel.CURRENT) + " Or Higher", DebugLevel.ALWAYS));
    }
}
