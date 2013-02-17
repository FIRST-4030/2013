package edu.wpi.first.wpilibj.templates.debugging;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import java.util.Hashtable;

/**
 * Main RobotDebugger Class. Always use this instead of pushing directly to
 * SmartDashboard/Console.
 */
public class RobotDebugger {

    private static Hashtable table = new Hashtable();

    /**
     * This pushes this info to the SmartDashboard/Console.
     */
    private static void push(String key, String message, boolean isConsole, boolean isDashboard) {
        if (key == null || message == null) {
            throw new IllegalArgumentException("No Null Arguments");
        }
        if (VstM.Debug.DEBUG && (isConsole || isDashboard)) {
            if (!message.equals((String) table.get(key))) {
                table.put(key, message);
                if (VstM.Debug.CONSOLE && isConsole) {
                    System.out.println("DebugChange: " + key + ": " + message);
                }

                if (VstM.Debug.DASHBOARD & isDashboard) {
                    SmartDashboard.putString(key, message);
                }
            }
        }
    }

    /**
     * Push this raw info. This should not be used for status of SubSystems,
     * only for other places. If you have a subsystem it should inherent
     * Debuggable, then you should push it.
     */
    protected static void push(DebugInfo di) {
        if (VstM.Debug.DEBUG) {
            push(di.key(), di.message(), di.isConsole(), di.isDashboard());
        }
    }

    /**
     * Check the status of the Debuggable and push it if Debugging is one.
     */
    public static void push(Debuggable d) {
        if (VstM.Debug.DEBUG) {
            d.getStatus().debug();
        }
    }

    /**
     * Push this DebugOutput if Debugging.
     */
    public static void push(DebugOutput dp) {
        if (VstM.Debug.DEBUG) {
            dp.debug();
        }
    }

    /**
     * Clear the map. This will basically force RobotDebugger to push the next
     * values of keys to SmartDashboard/Console.
     *
     * Regularly the RobotDebugger stores the last set value for a key, and
     * won't push to Console/SmartDashboard unless that value has changed. This
     * method removes all stored key values.
     */
    public static void clearMap() {
        table = new Hashtable();
    }
}