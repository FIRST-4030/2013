package org.ingrahamrobotics.robot2013.variablestores.dynamic;

/**
 * Dynamic Climber Variable Store.
 *
 * @author daboross
 */
public final class DVstLimitSwitches {

    private static boolean upper;
    private static boolean lower;
    private static boolean deploy;

    public static boolean upper() {
        return upper;
    }

    public static boolean lower() {
        return lower;
    }

    public static boolean deploy() {
        return deploy;
    }

    public static void setUpper(boolean upperValue) {
        upper = upperValue;
    }

    public static void setLower(boolean lowerValue) {
        lower = lowerValue;
    }

    public static void setDeploy(boolean deployValue) {
        deploy = deployValue;
    }
}
