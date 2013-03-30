package edu.wpi.first.wpilibj.templates.variablestores.dynamic;

//import edu.wpi.first.wpilibj.templates.commands.ClimberEnabledAndDisabledActions;
/**
 * Dynamic Climber Variable Store.
 *
 * @author daboross
 */
public final class DVstClimber {

//    private static boolean climberEnabled;
//
//    public static boolean climberEnabled() {
//        return climberEnabled;
//    }
//
//    public static void setClimberEnabled(final boolean climberEnabledSet) {
//        if (climberEnabledSet != climberEnabled) {
//            if (climberEnabledSet) {
//                climberEnabledActions();
//            } else {
//                climberDisabledActions();
//            }
//        }
//        climberEnabled = climberEnabledSet;
//    }
//
//    private static void climberEnabledActions() {
//        ClimberEnabledAndDisabledActions.climberEnabledActions();
//    }
//
//    private static void climberDisabledActions() {
//        ClimberEnabledAndDisabledActions.climberDisabledActions();
//    }
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
