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

    public static void initClimber() {
        if (!isClimberEnabledInit) {
            initIsClimberEnabled();
        }
    }

    public static boolean getClimberEnabled() {
        if (!isClimberEnabledInit) {
            initIsClimberEnabled();
        }
        return ((Boolean) isClimberEnabled.getSelected()).booleanValue();
    }
    private static boolean isClimberEnabledInit = false;
    private static SendableChooser isClimberEnabled;

    private static void initIsClimberEnabled() {
        isClimberEnabledInit = true;
        isClimberEnabled = new SendableChooser();
        isClimberEnabled.addDefault("Disable Climber", Boolean.FALSE);
        isClimberEnabled.addObject("Enable Climber", Boolean.TRUE);
        SmartDashboard.putData("ClimberEnabled", isClimberEnabled);
    }
}
