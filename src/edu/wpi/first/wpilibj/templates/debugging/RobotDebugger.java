package edu.wpi.first.wpilibj.templates.debugging;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import java.util.Hashtable;

public class RobotDebugger {

    private static Hashtable table = new Hashtable();

    public static void push(String key, String value) {
        if (!value.equals((String) table.get(key))) {
            table.put(key, value);
            if (VstM.Debug.DEBUG) {
                if (VstM.Debug.CONSOLE) {
                    System.out.println("Update: " + key + ": " + value);
                }

                if (VstM.Debug.DASHBOARD) {
                    SmartDashboard.putString("Status:" + key, value);
                }
            }
        }
    }

    public static void push(DebugInfo di) {
        if (VstM.Debug.DEBUG) {
            push(di.key(), di.message());
        }
    }

    public static void push(Debuggable d) {
        if (VstM.Debug.DEBUG) {
            push(d.getStatus());
        }
    }
}