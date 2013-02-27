package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimberWedgeSolenoid;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.helpers.solenoid.SolenoidPair;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author daboross
 */
public class ClimberWedgeSolenoids extends Subsystem implements Debuggable {

    private SolenoidPair climberWedgeSolenoids = new SolenoidPair(VstM.SOLENOID.CLIMBER_WEDGE_EXTENDING_SIDE, VstM.SOLENOID.CLIMBER_WEDGE_RETRACTING_SIDE);

    public ClimberWedgeSolenoids() {
        System.out.println("SubSystem Created: ClimberWedgeSolenoids");
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunClimberWedgeSolenoid());
    }

    /**
     * This sets the ClimberWedgeSolenoid to extend state.
     *
     * To stop extending, call retract().
     */
    public void extend() {
        climberWedgeSolenoids.extend();
    }

    /**
     * This sets the ClimberWedgeSolenoid to retract state.
     *
     * To stop retracting, call extend().
     */
    public void retract() {
        climberWedgeSolenoids.retract();
    }

    public DebugOutput getStatus() {
        return new InfoState("ClimberWedgeSolenoids", climberWedgeSolenoids.getState(), DebugLevel.MID);
    }
}
