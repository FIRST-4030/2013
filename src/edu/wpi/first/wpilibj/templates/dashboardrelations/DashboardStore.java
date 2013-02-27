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
    /**
     * False is left, true is right.
     */
    private static BooleanDashObject cameraPosition;
    private static IntegerDashObject debugLevelChanger;

    static {
        debugLevelChanger = new IntegerDashObject("-DebugLevelChanger", new String[]{"All Messages", "Lowest or Higher", "Low or Higher", "Mid or Higher", "High or Higher", "Highest or Higher", "Only \"Always\" Messages"}, 6);
        checkDebugLevelChanger();

        isClimberEnabledObject = new BooleanDashObject("-IsClimberEnabled", "Enable Climber", "Disable Climber", false);
        RobotDebugger.push(new InfoState("Climber:Enabled", "No", DebugLevel.ALWAYS));

        cameraPosition = new BooleanDashObject("-CameraPosition", "Camera Left", "Camera Right", true);
        RobotDebugger.push(new InfoState("Camera:Position", "Camera Left", DebugLevel.ALWAYS));

        SmartDashboard.putNumber("Climber Speed Multiplier", 1.0);
    }

    public static double getClimberSpeedMultiplier() {
        return SmartDashboard.getNumber("Climber Speed Multiplier");

    }

    public static boolean getIsClimberEnabled() {
        final boolean enabledGet = isClimberEnabledObject.getValue();
        RobotDebugger.push(new InfoState("Climber:Enabled", enabledGet ? "Yes" : "No", DebugLevel.ALWAYS));
        return enabledGet;
    }

    /**
     * True for left, False for right.
     */
    public static boolean getCameraPosition() {
        final boolean enabledGet = cameraPosition.getValue();
        RobotDebugger.push(new InfoState("Camera:Position", enabledGet ? "Camera Left" : "Camera Right", DebugLevel.ALWAYS));
        return enabledGet;
    }

    private static int getDebugLevelChanger() {
        return debugLevelChanger.getValue();
    }

    public static void checkDebugLevelChanger() {
        int debugLevelChange = getDebugLevelChanger();
        if (debugLevelChange < DebugLevel.CURRENT) {
            DebugLevel.CURRENT = debugLevelChange;
            RobotDebugger.push(new InfoState("Debug To Show:", DebugLevel.getNameOf(DebugLevel.CURRENT) + " Or Higher", DebugLevel.ALWAYS));
            RobotDebugger.reMap();
        }
    }
}
