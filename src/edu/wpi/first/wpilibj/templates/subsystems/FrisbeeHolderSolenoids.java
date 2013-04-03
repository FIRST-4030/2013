package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.debugging.InfoState;
import edu.wpi.first.wpilibj.templates.helpers.solenoid.SolenoidPair;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

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
