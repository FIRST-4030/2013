package edu.wpi.first.wpilibj.templates.debugging;

/**
 * This is a group of Debug Info. You can use RobotDebugger.push() to deal with
 * it if you find yourself with one.
 */
public class DebugInfoGroup extends DebugOutput {

    private final DebugInfo[] infos;

    public DebugInfoGroup(final DebugInfo[] listOfInfo) {
        infos = listOfInfo;
    }

    protected void debug() {
        for (int i = 0; i < infos.length; i++) {
            if (infos[i] != null) {
                RobotDebugger.pushInfo(infos[i]);
            }
        }
    }
}
