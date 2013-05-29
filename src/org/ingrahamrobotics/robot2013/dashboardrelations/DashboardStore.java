package org.ingrahamrobotics.robot2013.dashboardrelations;

import edu.wpi.first.wpilibj.networktables2.TableKeyExistsWithDifferentTypeException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.infos.DebugStatus;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;

/**
 * This is a variable store that stores values that are on the SmartDashboard.
 * Each time you ask for one it will check the SmartDashboard and return you the
 * value the SmartDashboard gives it.
 *
 * @author daboross
 */
public final class DashboardStore {

    private static final double defaultClimberSpeedMultiplier = 0.5;
    private static final double defaultShooterMotor1SpeedMultiplier = 0.4;
    private static final double defaultShooterMotor2SpeedMultiplier = 0.4;
    private static final double defaultGroundDriveSpeedMultiplier = 0.5;
    private static final int defaultAutoCommandTime = 7;

    public static double getClimberSpeedMultiplier() {
        double val;
        try {
            val = SmartDashboard.getNumber("Climber Speed Multiplier Setter");
        } catch (TableKeyNotDefinedException tknde) {
            val = 0;
        } catch (TableKeyExistsWithDifferentTypeException tkewdte) {
            val = 0;
        }
        if (val == 0) {
            return defaultClimberSpeedMultiplier;
        } else {
            return val;
        }
    }

    public static double getShooterMotor1SpeedMultiplier() {
        double val;
        try {
            val = SmartDashboard.getNumber("Shooter Motor Speed 1 Multiplier Setter");
        } catch (TableKeyNotDefinedException tknde) {
            val = 0;
        } catch (TableKeyExistsWithDifferentTypeException tkewdte) {
            val = 0;
        }
        if (val == 0) {
            return defaultShooterMotor1SpeedMultiplier;
        } else {
            return val;
        }
    }

    public static double getShooterMotor2SpeedMultiplier() {
        double val;
        try {
            val = SmartDashboard.getNumber("Shooter Motor Speed 2 Multiplier Setter");
        } catch (TableKeyNotDefinedException tknde) {
            val = 0;
        } catch (TableKeyExistsWithDifferentTypeException tkewdte) {
            val = 0;
        }
        if (val == 0) {
            return defaultShooterMotor2SpeedMultiplier;
        } else {
            return val;
        }
    }

    public static double getGroundDriveSpeedMultiplier() {
        double val;
        try {
            val = SmartDashboard.getNumber("Ground Drive Speed Multiplier Setter");
        } catch (TableKeyNotDefinedException tknde) {
            val = 0;
        } catch (TableKeyExistsWithDifferentTypeException tkewdte) {
            val = 0;
        }
        if (val == 0) {
            return defaultGroundDriveSpeedMultiplier;
        } else {
            return val;
        }
    }

    public static int getAutoCommandTimeout() {
        int val;
        try {
            val = (int) (SmartDashboard.getNumber("Auto Command Max Wait Time Setter") * 1000);
        } catch (TableKeyNotDefinedException tknde) {
            val = 0;
        } catch (TableKeyExistsWithDifferentTypeException tkewdte) {
            val = 0;
        }
        if (val == 0) {
            val = defaultAutoCommandTime * 1000;
        }
        RobotDebugger.push(new DebugStatus("Auto Command Max Wait Time", val, DebugLevel.HIGHEST));
        return val;
    }
}
