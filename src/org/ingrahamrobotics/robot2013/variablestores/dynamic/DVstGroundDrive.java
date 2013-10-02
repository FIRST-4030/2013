package org.ingrahamrobotics.robot2013.variablestores.dynamic;

import org.ingrahamrobotics.robot2013.dashboardrelations.DashboardStore;

/**
 *
 */
public class DVstGroundDrive {

    private static boolean reversed;
    private static boolean tankDrive;
    private static boolean useDashboardMultiplier = false;
    private static double speedMultiplier = 1;

    public static boolean isReversed() {
        return reversed;
    }

    public static boolean isTankDrive() {
        return tankDrive;
    }

    public static double getSpeedMultiplier() {
        if (useDashboardMultiplier) {
            return DashboardStore.getGroundDriveSpeedMultiplier();
        } else {
            return speedMultiplier;
        }
    }

    public static void setReversed(boolean reversed) {
        DVstGroundDrive.reversed = reversed;
    }

    public static void setTankDrive(boolean tankDrive) {
        DVstGroundDrive.tankDrive = tankDrive;
    }

    public static void setSpeedMultiplier(double speedMultiplier) {
        DVstGroundDrive.speedMultiplier = speedMultiplier;
    }
}
