package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.helpers.solenoid.SolenoidPair;
import org.ingrahamrobotics.robot2013.variablestores.VstM;

/**
 * Solenoids for Climber 'Wedgies'.
 */
public class Climber10PointSolenoids extends Subsystem {

    private final SolenoidPair climb10PointSolenoids = new SolenoidPair(VstM.SOLENOID.CLIMBER_10_POINT_EXTENDING_SIDE, VstM.SOLENOID.CLIMBER_10_POINT_RETRACTING_SIDE, false);

    public Climber10PointSolenoids() {
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

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.HIGHEST, "10PointClimberSolenoids", climb10PointSolenoids.getState());
    }
}
