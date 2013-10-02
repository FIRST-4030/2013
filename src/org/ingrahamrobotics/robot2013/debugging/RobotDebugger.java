package org.ingrahamrobotics.robot2013.debugging;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Enumeration;
import java.util.Hashtable;
import org.ingrahamrobotics.robot2013.HM;

/**
 * Main RobotDebugger Class. Always use this instead of pushing directly to
 * SmartDashboard/Console.
 */
public class RobotDebugger {

    private static final RobotDebugger main = new RobotDebugger();
    private final Hashtable consoleTable = new Hashtable();
    private final Hashtable dashTable = new Hashtable();

    private void pushToConsole(DebugLevel level, String key, String value) {
        System.out.println("[Debug] [" + level.name + "] [" + key + "] " + value);
    }

    private void pushToDash(String key, String value) {
        SmartDashboard.putString(key.replace(':', '|'), value);
    }

    public void outputInfo(DebugOutput output) {
        if (output == null || output.key == null || output.message == null || output.level == null) {
            return;
        }
        if (output.level.value >= DebugLevel.CONSOLE.value) {
            DebugOutput oldConsoleInfo = (DebugOutput) consoleTable.get(output.key);
            if (oldConsoleInfo == null || !oldConsoleInfo.message.equals(output.message)) {
                pushToConsole(output.level, output.key, output.message);
                consoleTable.put(output.key, output);
            }
        }
        if (output.level.value >= DebugLevel.CURRENT.value) {
            pushToDash(output.key, output.message);
            dashTable.put(output.key, output);
        }
    }

    public void outputInfo(DebugLevel level, String key, String message) {
        if (level == null || key == null || message == null) {
            return;
        }
        DebugOutput output = null;
        if (level.value >= DebugLevel.CONSOLE.value) {
            DebugOutput oldConsoleInfo = (DebugOutput) consoleTable.get(key);
            if (oldConsoleInfo == null || !oldConsoleInfo.message.equals(message)) {
                pushToConsole(level, key, message);
                if (output == null) {
                    output = new DebugOutput(key, message, level);
                }
                consoleTable.put(key, output);
            }
        }
        if (level.value >= DebugLevel.CURRENT.value) {
            pushToDash(key, message);
            if (output == null) {
                output = new DebugOutput(key, message, level);
            }
            dashTable.put(key, output);
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
    public void pushAll() {
        Enumeration e = dashTable.elements();
        while (e.hasMoreElements()) {
            DebugOutput d = (DebugOutput) e.nextElement();
            if (d.level.value >= DebugLevel.CURRENT.value) {
                pushToDash(d.key, d.message);
            }
        }
    }

    public static void output(DebugLevel level, String key, String value) {
        main.outputInfo(level, key, value);
    }

    public static void output(DebugLevel level, String key, int value) {
        main.outputInfo(level, key, String.valueOf(value));
    }

    public static void output(DebugLevel level, String key, double value) {
        main.outputInfo(level, key, String.valueOf(HM.round(value)));
    }

    public static void output(DebugLevel level, String key, short value) {
        main.outputInfo(level, key, String.valueOf(value));
    }

    public static void output(DebugLevel level, String key, boolean value) {
        main.outputInfo(level, key, String.valueOf(value ? "Yes" : "No"));
    }

    public static void output(DebugOutput output) {
        main.outputInfo(output);
    }

    public static void repushDashboard() {
        main.pushAll();
    }
}
