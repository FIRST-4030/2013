package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.dashboardrelations.DashboardStore;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;

/**
 *
 * @author daboross
 */
public class RunCameraServo extends CommandBase {

    public RunCameraServo() {
        requires(cameraServo);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (DashboardStore.getCameraPosition()) {
            cameraServo.turnLeft();
        } else {
            cameraServo.turnRight();
        }
        RobotDebugger.push(cameraServo);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
}
