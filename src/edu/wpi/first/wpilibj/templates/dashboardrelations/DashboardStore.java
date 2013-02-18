package edu.wpi.first.wpilibj.templates.dashboardrelations;

/**
 * This is a variable store that stores values that are on the SmartDashboard.
 * Each time you ask for one it will check the SmartDashboard and return you the
 * value the SmartDashboard gives it.
 *
 * @author daboross
 */
public final class DashboardStore {

    private static BooleanDashObject isClimberEnabledObject;
    private static BooleanDashObject isClimberAutoObject;

    public static void reInit() {
        initIsClimberEnabled();
        initIsClimberAuto();
        isClimberEnabledObject.reCreate();
        isClimberAutoObject.reCreate();
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

    public static void initIsClimberAuto() {
        if (isClimberAutoObject == null) {
            isClimberAutoObject = new BooleanDashObject("-IsClimberAuto", "Climber Mode: Auto", "Climber Mode: Manual", false);
        }
    }

    public static boolean getIsClimberAuto() {
        initIsClimberAuto();
        return isClimberAutoObject.getValue();
    }
}
