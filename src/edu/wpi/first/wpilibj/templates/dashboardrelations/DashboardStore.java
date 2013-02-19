package edu.wpi.first.wpilibj.templates.dashboardrelations;

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
    private static IntegerDashObject debugLevelChanger;

    public static void reInit() {
        initDebugLevelChanger();
        debugLevelChanger.reCreate();
        RobotDebugger.push(new InfoState("Debug To Show:", DebugLevel.getNameOf(DebugLevel.CURRENT) + " Or Higher", DebugLevel.ALWAYS));
        initIsClimberEnabled();
        isClimberEnabledObject.reCreate();
    }

    public static void initIsClimberEnabled() {
        if (isClimberEnabledObject == null) {
            isClimberEnabledObject = new BooleanDashObject("-IsClimberEnabled", "Enable Climber", "Disable Climber", false);
        }
    }

    public static boolean getIsClimberEnabled() {
        initIsClimberEnabled();
        return isClimberEnabledObject.getValue();
    }

    public static void initDebugLevelChanger() {
        if (debugLevelChanger == null) {
            debugLevelChanger = new IntegerDashObject("-DebugLevelChanger", new String[]{"All Messages", "Lowest or Higher", "Low or Higher", "Mid or Higher", "High or Higher", "Highest or Higher", "Only \"Always\" messages"}, 6);
        }
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
