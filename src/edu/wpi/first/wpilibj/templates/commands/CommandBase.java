package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system.
 */
public abstract class CommandBase extends Command {

    /**
     * SubSystems.
     */
    public static Compressor compressor = new Compressor();
    public static Camera mainCamera = new Camera();
    public static Climber climber = new Climber();
    public static PressureSwitch pressureSwitch = new PressureSwitch();
    public static GroundDrive groundDrive = new GroundDrive();
    public static RunClimber runClimber = new RunClimber();
    public static ClimberLimitSwitch climberLimitSwitch = new ClimberLimitSwitch();
    public static ShooterSolenoid shooterSolenoid = new ShooterSolenoid();
    public static ShooterMotors shooterMotors = new ShooterMotors();
    public static TestMotors testMotors = null;// new TestMotors(); I think we have GroundDrive already doing this.
    

    public static void init() {
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
