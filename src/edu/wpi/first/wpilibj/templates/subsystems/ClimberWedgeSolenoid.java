package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunClimberWedgeSolenoid;
import edu.wpi.first.wpilibj.templates.debugging.DebugLevel;
import edu.wpi.first.wpilibj.templates.debugging.DebugOutput;
import edu.wpi.first.wpilibj.templates.debugging.DebugStatus;
import edu.wpi.first.wpilibj.templates.debugging.Debuggable;
import edu.wpi.first.wpilibj.templates.variablestores.VstM;

/**
 *
 * @author daboross
 */
public class ClimberWedgeSolenoid extends Subsystem implements Debuggable {

    private Solenoid solenoid1, solenoid2;
    private String status = "Not Set";

    public ClimberWedgeSolenoid() {
        System.out.println("Created: ClimberWedgeSolenoid");
        solenoid1 = new Solenoid(VstM.SOLENOID.CLIMBER_WEDGE_SIDE_1);
        solenoid2 = new Solenoid(VstM.SOLENOID.CLIMBER_WEDGE_SIDE_2);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RunClimberWedgeSolenoid());
    }

    /**
     * This sets the ClimberWedgeSolenoid to extend state.
     *
     * To stop extending, call retract() or stayPut().
     */
    public void extend() {
        status = "Extending";
        setStaying(false);
        solenoid1.set(true);
        solenoid2.set(false);
    }

    /**
     * This sets the ClimberWedgeSolenoid to retract state.
     *
     * To stop retracting, call extend() or stayPut().
     */
    public void retract() {
        status = "Retracting";
        setStaying(false);
        solenoid2.set(true);
        solenoid1.set(false);
    }

    /**
     * This sets the ClimberWedgeSolenoid to "stay put" mode. This is a special
     * mode which will make the solenoid switch quickly between extending and
     * retracting.
     *
     * This will only work if the update() method is called frequently.
     *
     * To stop staying put, call retract() or extend().
     */
    public void stayPut() {
        setStaying(true);
    }

    public void update() {
        if (staying) {
            if (lastUpdate + 100 < System.currentTimeMillis()) {
                System.out.println("ClimberWedgeSolenoid: Updated");
                stayingState = !stayingState;
                if (stayingState) {
                    retract();
                } else {
                    extend();
                }
                lastUpdate = System.currentTimeMillis();
            }
        }
    }

    private void setStaying(boolean state) {
        if (state) {
            lastUpdate = System.currentTimeMillis();
            stayingState = false;
        }
        staying = state;

    }

    public DebugOutput getStatus() {
        return new DebugStatus("ClimberWedgeSolenoid", status, DebugLevel.HIGH);
    }
    private boolean staying = false;
    private long lastUpdate;
    /**
     * true is up, false is down.
     */
    private boolean stayingState;
}
