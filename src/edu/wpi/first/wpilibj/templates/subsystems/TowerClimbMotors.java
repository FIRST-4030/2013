package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.TowerClimb;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * Robot SubSystem TowerClimbMotors.
 */
public class TowerClimbMotors extends Subsystem {

    private Jaguar motor1 = new Jaguar(VstM.PWM.TOWER_MOTOR_1_PORT);
    private Jaguar motor2 = new Jaguar(VstM.PWM.TOWER_MOTOR_2_PORT);

    public TowerClimbMotors() {
    }

    public void setSpeed(double speed) {
        double buffSpeed = speed > 1 ? 1 : speed < -1 ? -1 : speed;
        motor1.set(buffSpeed);
        motor2.set(buffSpeed);
    }

    public void stop() {
        setSpeed(0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TowerClimb());
    }
}