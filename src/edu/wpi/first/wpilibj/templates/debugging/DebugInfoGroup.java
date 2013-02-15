package edu.wpi.first.wpilibj.templates.debugging;

/**
 *
 */
public class DebugInfoGroup {

    private DebugInfo[] infos;

    public DebugInfoGroup(DebugInfo[] listOfInfo) {
        infos = listOfInfo;
    }

    public DebugInfoGroup(DebugInfo singleInfo) {
        infos = new DebugInfo[]{singleInfo};
    }

    protected void printEach() {
        for (int i = 0; i < infos.length; i++) {
            RobotDebugger.push(infos[i]);
        }
    }
}
