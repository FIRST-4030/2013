package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunFrisbeeDumperSolenoid;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.helpers.solenoid.SolenoidPair;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author daboross
 */
public final class FrisbeeDumperSolenoid extends Subsystem implements Debuggable {

    private SolenoidPair frisbeeDumperSolenoids = new SolenoidPair(VstM.SOLENOID.FRISBEE_DUMP_EXTENDING_SIDE, VstM.SOLENOID.FRISBEE_DUMP_RETRACTING_SIDE);

    public FrisbeeDumperSolenoid() {
        System.out.println("SubSystem Created: FrisbeeDumperSolenoid");
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunFrisbeeDumperSolenoid());
    }

    public void startExpand() {
        frisbeeDumperSolenoids.extend();
    }

    public void startRetract() {
        frisbeeDumperSolenoids.retract();
    }

    public DebugOutput getStatus() {

        return new DebugStatus("FRisbeeDumperSolenoid:Extending", frisbeeDumperSolenoids.isExtending(), DebugLevel.MID);
    }
}
