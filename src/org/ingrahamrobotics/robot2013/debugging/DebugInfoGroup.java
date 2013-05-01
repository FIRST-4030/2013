package org.ingrahamrobotics.robot2013.debugging;

/**
 * This is a group of Debug Info. You can use RobotDebugger.push() to deal with
 * it if you find yourself with one.
 */
public class DebugInfoGroup extends DebugOutput {

    private final DebugInfo[] infos;

    public DebugInfoGroup(final DebugInfo[] listOfInfo) {
        infos = new DebugInfo[listOfInfo.length];
        System.arraycopy(listOfInfo, 0, infos, 0, listOfInfo.length);
    }

    protected void debug() {
        for (int i = 0; i < infos.length; i++) {
            if (infos[i] != null) {
                RobotDebugger.pushInfo(infos[i]);
            }
        }
    }
}
