package edu.wpi.first.wpilibj.templates.debugging;

import edu.wpi.first.wpilibj.templates.helpers.ProcessError;

/**
 *
 * @author daboross
 */
public class PossiblyErroredReport extends DebugOutput {
    
    private DebugInfoGroup infoGroup;
    
    public PossiblyErroredReport(String name, ProcessError error, DebugInfo[] other, int level) {
        DebugInfo[] list = new DebugInfo[other.length + 3];
        System.arraycopy(other, 0, list, 0, other.length);
        list[other.length + 0] = new DebugStatus(name + ":IsErrored", error.isError(), level);
        list[other.length + 1] = new DebugStatus(name + ":Error", error.getMessage(), level);
        list[other.length + 2] = new DebugStatus(name + ":Error:Creator", error.getCreator(), level);
        infoGroup = new DebugInfoGroup(list);
    }
    
    protected void debug() {
        infoGroup.debug();
    }
}
