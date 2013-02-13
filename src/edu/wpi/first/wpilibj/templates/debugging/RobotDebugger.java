package edu.wpi.first.wpilibj.templates.debugging;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;
import java.util.Hashtable;

public class RobotDebugger {

    public static void push(String key, String value) {
        if (VstM.Debug.DEBUG) {
            if (VstM.Debug.CONSOLE) {
                System.out.println("Debug Status: " + key + ": " + value);
            }
            if (VstM.Debug.DASHBOARD) {
                SmartDashboard.putString("Debug:" + key, value);
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