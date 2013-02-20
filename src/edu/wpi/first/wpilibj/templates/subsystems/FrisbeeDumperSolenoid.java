package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunFrisbeeDumperSolenoid;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author daboross
 */
public class FrisbeeDumperSolenoid extends Subsystem {

    private Solenoid solenoid1, solenoid2;

    public FrisbeeDumperSolenoid() {
        System.out.println("SubSystem Created: FrisbeeDumperSolenoid");
        solenoid1 = new Solenoid(VstM.SOLENOID.FRISBEE_DUMP_1);
        solenoid1.set(false);
        solenoid2 = new Solenoid(VstM.SOLENOID.FRISBEE_DUMP_2);
        solenoid2.set(false);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunFrisbeeDumperSolenoid());
    }

    public void startExpand() {
        solenoid1.set(true);
        solenoid1.set(false);
    }
    public void startRetract(){
        solenoid2.set(true);
        solenoid1.set(false);
    }
}
