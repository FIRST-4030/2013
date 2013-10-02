package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.RobotDebugger;
import org.ingrahamrobotics.robot2013.helpers.solenoid.SolenoidPair;
import org.ingrahamrobotics.robot2013.variablestores.VstM;

/**
 *
 */
public final class FrisbeeHolderSolenoids extends Subsystem {

    private final SolenoidPair frisbeeHolderSolenoids = new SolenoidPair(VstM.SOLENOID.FRISBEE_HOLDER_EXTENDING_SIDE, VstM.SOLENOID.FRISBEE_HOLDER_RETRACTING_SIDE, true);

    public FrisbeeHolderSolenoids() {
        System.out.println("SubSystem Created: FrisbeeDumperSolenoids");
    }

    protected void initDefaultCommand() {
        //setDefaultCommand(new OldRunFrisbeeDumperSolenoid());
    }

    public void extend() {
        frisbeeHolderSolenoids.extend();
    }

    public void retract() {
        frisbeeHolderSolenoids.retract();
    }

    public void outputStatus() {
        RobotDebugger.output(DebugLevel.HIGHEST, "FrisbeeHolderSolenoids:DumperState", frisbeeHolderSolenoids.getState());
    }
}
