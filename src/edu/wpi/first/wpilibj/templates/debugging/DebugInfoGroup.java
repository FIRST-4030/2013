package edu.wpi.first.wpilibj.templates.debugging;

/**
 *
 */
public class DebugInfoGroup {

    private DebugInfo[] infos;

    public DebugInfoGroup(DebugInfo[] listOfInfo) {
        infos = listOfInfo;
    }

    protected void printEach() {
        for (int i = 0; i < infos.length; i++) {
            RobotDebugger.push(infos[i]);
        }
    }
}
