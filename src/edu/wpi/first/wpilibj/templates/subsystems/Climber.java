package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimber;
import edu.wpi.first.wpilibj.templates.debugging.DebugInfo;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author Robotics
 */
public class Climber extends Subsystem implements Debuggable {

<<<<<<< HEAD
    //objects needed by climber
=======
    // Objects needed by climber
    private DigitalInput lowerLimit = new DigitalInput(VstM.Relays.LOWER_LIMIT_SWITCH);
    private DigitalInput upperLimit = new DigitalInput(VstM.Relays.UPPER_LIMIT_SWITCH);
>>>>>>> cb7ed8d5a3fce72cb6ce165f7d0d223e8db5f646
    private Jaguar climber = new Jaguar(VstM.PWM.CLIMBER_MOTOR);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        setDefaultCommand(new RunClimber());
    }

    public void runLadder(double speed) {
        climber.set(speed);
    }

    public void stop() {
        climber.stopMotor();
    }
<<<<<<< HEAD
=======

    public boolean isAtLowerLimit() {
        /* 
         * this returns true if it's at the lower limit, assuming
         * that the switch is normally open.
         */
        return lowerLimit.get(); //TODO: invert if normally closed
    }

    public boolean isAtUpperLimit() {
        /* 
         * this returns true if it's at the upper limit, assuming
         * that the switch is normally open.
         */
        return upperLimit.get(); //TODO: invert if normally closed
    }

    public DebugInfo getStatus() {
        return new DebugInfo("Climber:Status", "Climber Speed:" + climber.get());
    }
>>>>>>> cb7ed8d5a3fce72cb6ce165f7d0d223e8db5f646
}
