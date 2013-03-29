package edu.wpi.first.wpilibj.templates.variablestores.dynamic;

import edu.wpi.first.wpilibj.templates.DisableNotifable;
import edu.wpi.first.wpilibj.templates.RobotMain;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfoGroup;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.subsystems.ShooterMotors;

/**
 *
 * @author daboross
 */
public class DVstShooterMotors implements Debuggable {

    private double onSpeed = 0.5;
    private boolean on;
    private final ShooterMotors shooterMotors;

    public void setOnSpeed(final double onSpeedSet) {
        this.onSpeed = onSpeedSet;
    }

    public DVstShooterMotors(ShooterMotors shooterMotors) {
        Notif n = new Notif();
        RobotMain.addDisableNotifable(n);
        this.shooterMotors = shooterMotors;
    }

    public void turnOff() {
        shooterMotors.setSpeed(0);
        on = false;
        pushMe();
    }

    public void turnOn() {
        shooterMotors.setSpeed(onSpeed);
        on = true;
        pushMe();
    }

    private void pushMe() {
        RobotDebugger.push(this);
    }

    public DebugOutput getStatus() {
        return new DebugInfoGroup(new DebugInfo[]{new DebugStatus("ShooterMotors:Running", on, DebugLevel.HIGHEST),
            new DebugStatus("ShooterMotors:SpeedWhenOn", "%" + ((int) (onSpeed * 100)), DebugLevel.HIGHEST)
        });
    }

    public class Notif implements DisableNotifable {

        private Notif() {
        }

        public void disable() {
            turnOff();
        }
    }
}
