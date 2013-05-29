/*
 * Author: Dabo Ross
 * Website: www.daboross.net
 * Email: daboross@daboross.net
 */
package org.ingrahamrobotics.robot2013.variablestores.dynamic;

/**
 *
 * @author daboross
 */
public class DVstGroundDrive {

    private static boolean reversed;
    private static boolean tankDrive;

    public static boolean isReversed() {
        return reversed;
    }

    public static boolean isTankDrive() {
        return tankDrive;
    }

    public static void setReversed(boolean reversed) {
        DVstGroundDrive.reversed = reversed;
    }

    public static void setTankDrive(boolean tankDrive) {
        DVstGroundDrive.tankDrive = tankDrive;
    }
}
