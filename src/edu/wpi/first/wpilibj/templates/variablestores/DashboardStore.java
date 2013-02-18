package edu.wpi.first.wpilibj.templates.variablestores;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a variable store that stores values that are on the SmartDashboard.
 * Each time you ask for one it will check the SmartDashboard and return you the
 * value the SmartDashboard gives it.
 *
 * @author daboross
 */
public class DashboardStore {

    public static void reInit() {
        isClimberEnabledInit = false;
        isClimberAutoInit = false;
        isClimberAuto = null;
        isClimberEnabled = null;
        initIsClimberEnabled();
        initIsClimberAuto();
    }
    private static boolean isClimberEnabledInit = false;
    private static SendableChooser isClimberEnabled;

    public static void initIsClimberEnabled() {
        if (!isClimberEnabledInit) {
            isClimberEnabledInit = true;
            isClimberEnabled = new SendableChooser();
            isClimberEnabled.addDefault("Disable Climber", Boolean.FALSE);
            isClimberEnabled.addObject("Enable Climber", Boolean.TRUE);
            SmartDashboard.putData("ClimberEnabled", isClimberEnabled);
        }
    }

    public static boolean getIsClimberEnabled() {
        initIsClimberEnabled();
        return ((Boolean) isClimberEnabled.getSelected()).booleanValue();
    }
    private static boolean isClimberAutoInit = false;
    private static SendableChooser isClimberAuto;

    public static void initIsClimberAuto() {
        if (!isClimberAutoInit) {
            isClimberAutoInit = true;
            isClimberAuto = new SendableChooser();
            isClimberAuto.addDefault("Climber Mode: Manual", Boolean.FALSE);
            isClimberAuto.addObject("Climber Mode: Auto", Boolean.TRUE);
            SmartDashboard.putData("ClimberAuto", isClimberAuto);
        }
    }

    public static boolean getIsClimberAuto() {
        initIsClimberAuto();
        return ((Boolean) isClimberAuto.getSelected()).booleanValue();
    }
}
