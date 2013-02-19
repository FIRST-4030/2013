package edu.wpi.first.wpilibj.templates.dashboardrelations;

import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;

/**
 * This is a variable store that stores values that are on the SmartDashboard.
 * Each time you ask for one it will check the SmartDashboard and return you the
 * value the SmartDashboard gives it.
 *
 * @author daboross
 */
public final class DashboardStore {

    private static BooleanDashObject isClimberEnabledObject;
    //private static BooleanDashObject isClimberAutoObject;
    private static IntegerDashObject debugLevelChanger;

    public static void reInit() {
        initIsClimberEnabled();
        //initIsClimberAuto();
        initDebugLevelChanger();
        isClimberEnabledObject.reCreate();
        //isClimberAutoObject.reCreate();
        debugLevelChanger.reCreate();
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

    /*public static void initIsClimberAuto() {
     if (isClimberAutoObject == null) {
     isClimberAutoObject = new BooleanDashObject("-IsClimberAuto", "Climber Mode: Auto", "Climber Mode: Manual", false);
     }
     }

     public static boolean getIsClimberAuto() {
     initIsClimberAuto();
     return isClimberAutoObject.getValue();
     }*/
    public static void initDebugLevelChanger() {
        if (debugLevelChanger == null) {
            debugLevelChanger = new IntegerDashObject("-DebugLevelChanger", new String[]{"All", "Highest", "High", "Mid", "Low", "Lowest",}, 5);
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
    }
}
