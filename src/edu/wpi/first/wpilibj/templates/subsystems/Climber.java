package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimber;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

public class Climber extends Subsystem implements Debuggable {

    private Jaguar climber = new Jaguar(VstM.PWM.CLIMBER_MOTOR);

    public void initDefaultCommand() {
        setDefaultCommand(new RunClimber());
    }

    public void runLadder(double speed) {
        climber.set(speed);
    }

    public void stop() {
        climber.stopMotor();
    }

    public DebugInfo getStatus() {
        return new DebugInfo("Climber:Status", "Climber Speed:" + climber.get());
    }
}
