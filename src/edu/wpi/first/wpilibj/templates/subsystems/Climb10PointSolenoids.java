package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.helpers.solenoid.SolenoidPair;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 * Solenoids for Climber 'Wedgies'.
 *
 * @author daboross
 */
public class Climb10PointSolenoids extends Subsystem implements Debuggable {

    private SolenoidPair climb10PointSolenoids = new SolenoidPair(VstM.SOLENOID.CLIMB_10_POINT_EXTENDING_SIDE, VstM.SOLENOID.CLIMB_10_POINT_RETRACTING_SIDE, false);

    public Climb10PointSolenoids() {
        System.out.println("SubSystem Created: ClimberWedgeSolenoids");
    }

    protected void initDefaultCommand() {
    }

    /**
     * This sets the ClimberWedgeSolenoid to extend state.
     *
     * To stop extending, call retract().
     */
    public void extend() {
        climb10PointSolenoids.extend();
    }

    /**
     * This sets the ClimberWedgeSolenoid to retract state.
     *
     * To stop retracting, call extend().
     */
    public void retract() {
        climb10PointSolenoids.retract();
    }

    public DebugOutput getStatus() {
        return new InfoState("10PointClimberSolenoids", climb10PointSolenoids.getState(), DebugLevel.HIGHEST);
    }
}
