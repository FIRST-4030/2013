package edu.wpi.first.wpilibj.templates.debugging;

/**
 * This is a group of Debug Info. You can use RobotDebugger to deal with it if
 * you find yourself with one. Though this should usually only be used in the
 * getStatus() method of a Debuggable.
 */
public class DebugInfoGroup extends DebugOutput {

    private DebugInfo[] infos;

    public DebugInfoGroup(DebugInfo[] listOfInfo) {
        infos = listOfInfo;
    }

    protected void debug() {
        for (int i = 0; i < infos.length; i++) {
            RobotDebugger.push(infos[i]);
        }
    }
}
