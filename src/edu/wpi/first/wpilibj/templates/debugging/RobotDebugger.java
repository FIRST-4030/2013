package edu.wpi.first.wpilibj.templates.debugging;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Main RobotDebugger Class. Always use this instead of pushing directly to
 * SmartDashboard/Console.
 */
public class RobotDebugger {

    private static Hashtable consoleTable = new Hashtable();
    private static Hashtable dashTable = new Hashtable();

    private static void consolePush(String key, String value) {
        System.out.println("[Debugger] " + key + ": " + value);
    }

    private static void dashboardPush(String key, String value) {
        SmartDashboard.putString(key, value);
    }

    /**
     * Push this raw info. This should not be used for status of SubSystems,
     * only for other places. If you have a subsystem it should inherent
     * Debuggable, then you should push it.
     */
    protected static void pushInfo(DebugInfo di) {
        if (di == null || di.key() == null || di.message() == null) {
            return;
        }
        String key = di.key();
        String val = di.message();
        int level = di.debugLevel();
        if (di.isConsole()) {
            DebugInfo dInfo = (DebugInfo) consoleTable.get(key);
            String oldConVal = null;
            if (dInfo != null) {
                oldConVal = dInfo.message();
            }
            if (oldConVal == null || !oldConVal.equals(val)) {
                if (level > DebugLevel.CURRENT) {
                    consolePush(key, val);
                }
            }
            consoleTable.put(key, di);
        }
        if (di.isDashboard()) {
            if (level > DebugLevel.CURRENT) {
                dashboardPush(key, val);
            }
            dashTable.put(key, di);
        }
    }

    /**
     * Check the status of the Debuggable and push it if Debugging is one.
     */
    public static void push(Debuggable d) {
        d.getStatus().debug();
    }

    /**
     * Push this DebugOutput if Debugging.
     */
    public static void push(DebugOutput dp) {
        dp.debug();
    }

    /**
     * Clear the map. This will basically force RobotDebugger to push the next
     * values of keys to SmartDashboard/Console.
     *
     * Regularly the RobotDebugger stores the last set value for a key, and
     * won't push to Console/SmartDashboard unless that value has changed. This
     * method removes all stored key values.
     */
    public static void reMap() {
        Enumeration e = dashTable.elements();
        while (e.hasMoreElements()) {
            DebugInfo d = (DebugInfo) e.nextElement();
            String key = d.key();
            String val = d.message();
            int level = d.debugLevel();
            if (level > DebugLevel.CURRENT) {
                dashboardPush(key, val);
            }
        }
    }
}