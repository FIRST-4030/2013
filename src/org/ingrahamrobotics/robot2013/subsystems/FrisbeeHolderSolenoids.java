package org.ingrahamrobotics.robot2013.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.ingrahamrobotics.robot2013.debugging.DebugLevel;
import org.ingrahamrobotics.robot2013.debugging.DebugOutput;
import org.ingrahamrobotics.robot2013.debugging.Debuggable;
import org.ingrahamrobotics.robot2013.debugging.infos.InfoState;
import org.ingrahamrobotics.robot2013.helpers.solenoid.SolenoidPair;
import org.ingrahamrobotics.robot2013.variablestores.VstM;

/**
 *
 * @author daboross
 */
public final class FrisbeeHolderSolenoids extends Subsystem implements Debuggable {

    private SolenoidPair frisbeeHolderSolenoids = new SolenoidPair(VstM.SOLENOID.FRISBEE_HOLDER_EXTENDING_SIDE, VstM.SOLENOID.FRISBEE_HOLDER_RETRACTING_SIDE, true);

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

    public DebugOutput getStatus() {
        return new InfoState("FrisbeeHolderSolenoids:DumperState", frisbeeHolderSolenoids.getState(), DebugLevel.HIGHEST);
    }
}
