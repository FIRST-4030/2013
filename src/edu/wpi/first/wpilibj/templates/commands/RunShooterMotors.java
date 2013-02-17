package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.RobotDebugger;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

/**
 * This Command Runs the Shooter Motors according to a speed that is changed
 * with buttons.
 *
 * The speed starts at 0, and when the up button is pressed it is increased by
 * 1/4 the max speed. When the down button is pressed it is decreased by 1/4 the
 * max speed.
 *
 * NOTE: When I say "Pressed", I mean released and then pressed.
 */
public class RunShooterMotors extends CommandBase implements Debuggable {

    public RunShooterMotors() {
        requires(shooterMotors);
    }

    protected void initialize() {
        shooterMotors.setSpeed(0);
    }
    private double motorSpeed = 0;
    private boolean buttonPressedLastUp = false;
    private boolean buttonPressedLastDown = false;

    protected void execute() {
        setSpeed();
        setMotors();
        RobotDebugger.push(shooterMotors);
        RobotDebugger.push(this);
    }

    private void setSpeed() {
        if (VstJ.getShooterMotorSpeedDownButtonValue() != buttonPressedLastDown) {
            if (buttonPressedLastDown) {
                if (motorSpeed - 0.25 > 0) {
                    motorSpeed -= 0.25;
                } else {
                    motorSpeed = 0;
                }
            }
            buttonPressedLastDown = !buttonPressedLastDown;
        }
        if (VstJ.getShooterMotorSpeedUpButtonValue() != buttonPressedLastUp) {
            if (buttonPressedLastUp) {
                if (motorSpeed + 0.25 < 1) {
                    motorSpeed += 0.25;
                } else {
                    motorSpeed = 1;
                }
            }
            buttonPressedLastUp = !buttonPressedLastUp;
        }
    }

    private void setMotors() {
        shooterMotors.setSpeed(motorSpeed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        motorSpeed = 0;
        shooterMotors.setSpeed(0);
    }

    protected void interrupted() {
        end();
    }

    public DebugOutput getStatus() {
        return new DebugStatus("ShooterMotors:ShouldBeSpeed", motorSpeed, DebugLevel.LOW);
    }
}
