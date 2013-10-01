package org.ingrahamrobotics.robot2013.variablestores.dynamic;

import org.ingrahamrobotics.robot2013.DisableNotifable;
import org.ingrahamrobotics.robot2013.RobotMain;
import org.ingrahamrobotics.robot2013.debugging.DebugInfo;
import org.ingrahamrobotics.robot2013.debugging.DebugInfoGroup;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.DebugOutput;
import org.ingrahamrobotics.robot2013.debugging.infos.DebugStatus;
import org.ingrahamrobotics.robot2013.debugging.Debuggable;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.subsystems.ShooterMotors;

/**
 *
 */
public class DVstShooterMotors implements Debuggable {

    private double onSpeed1 = 0.4;
    private double onSpeed2 = 0.4;
    private boolean on;
    private final ShooterMotors shooterMotors;

    public void setOnSpeed(final double onSpeedSet1, final double onSpeedSet2) {
        this.onSpeed1 = onSpeedSet1;
        this.onSpeed2 = onSpeedSet2;
        pushMe();
    }

    public DVstShooterMotors(ShooterMotors shooterMotors) {
        Notif n = new Notif();
        RobotMain.addDisableNotifable(n);
        this.shooterMotors = shooterMotors;
    }

    public void turnOff() {
        shooterMotors.setSpeed(0, 0);
        on = false;
        pushMe();
    }

    public void turnOn() {
        shooterMotors.setSpeed(onSpeed1, onSpeed2);
        on = true;
        pushMe();
    }

    private void pushMe() {
        RobotDebugger.push(this);
    }

    public DebugOutput getStatus() {
        return new DebugInfoGroup(new DebugInfo[]{new DebugStatus("ShooterMotors:Running", on, DebugLevel.HIGHEST),
            new DebugStatus("ShooterMotors:SpeedWhenOn1", "%" + ((int) (onSpeed1 * 100)), DebugLevel.HIGHEST),
            new DebugStatus("ShooterMotors:SpeedWhenOn2", "%" + ((int) (onSpeed2 * 100)), DebugLevel.HIGHEST)
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
