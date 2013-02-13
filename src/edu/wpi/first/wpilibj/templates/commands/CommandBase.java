package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system.
 */
public abstract class CommandBase extends Command {

    /**
     * SubSystems.
     */
    public static GroundDrive groundDrive = new GroundDrive();
    public static Compressor compressor = new Compressor();
    public static Camera mainCamera = new Camera();
    public static Climber climber = new Climber();
    public static PressureSwitch pressureSwitch = new PressureSwitch();
<<<<<<< HEAD
    public static TestMotors testMotors = new TestMotors();
    public static GroundDrive groundDrive = new GroundDrive();
    public static RunClimber runClimber = new RunClimber();
    public static ClimberLimitSwitch climberLimitSwitch = new ClimberLimitSwitch();
=======
>>>>>>> cb7ed8d5a3fce72cb6ce165f7d0d223e8db5f646

    public static void init() {
        OI.init();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
