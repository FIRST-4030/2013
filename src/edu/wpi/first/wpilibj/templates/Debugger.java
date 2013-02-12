package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

public class Debugger {
    
    public Debugger() {
    }
    
    public void push(String key, String value) {
        if (VstM.Debug.CONSOLE) {
            System.out.println("Debug Status: " + key + ": " + value);
        }
        if (VstM.Debug.DASHBOARD) {
            SmartDashboard.putString("Debug:" + key, value);
        }
    }
}