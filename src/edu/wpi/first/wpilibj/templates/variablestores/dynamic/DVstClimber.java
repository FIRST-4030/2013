package edu.wpi.first.wpilibj.templates.variablestores.dynamic;

/**
 * Dynamic Variable Store for Climber Vars.
 *
 * @author daboross
 */
public final class DVstClimber {

    private static boolean climberArmExtending;
    private static boolean climberReadyToExtend;
    private static boolean climberEnabled;

    public static boolean climberArmExtending() {
        return climberArmExtending;
    }

    public static void setClimberArmExtending(boolean climberArmExtendingValue) {
        climberArmExtending = climberArmExtendingValue;
    }

    public static boolean climberReadyToExtend() {
        return climberReadyToExtend;
    }

    public static void setClimberReadyToExtend(boolean climberReadyToExtendValue) {
        climberReadyToExtend = climberReadyToExtendValue;
    }

    public static boolean climberEnabled() {
        return climberEnabled;
    }

    public static void setClimberEnabled(boolean climberEnabledValue) {
        climberEnabled = climberEnabledValue;
    }

    public static final class LimitSwitches {

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
}
