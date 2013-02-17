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
    protected static Compressor compressor = new Compressor();
    protected static Camera mainCamera = new Camera();
    protected static Climber climber = new Climber();
    protected static PressureSwitch pressureSwitch = new PressureSwitch();
    protected static GroundDrive groundDrive = new GroundDrive();
    protected static RunClimber runClimber = new RunClimber();
    protected static ClimberLimitSwitch climberLimitSwitch = new ClimberLimitSwitch();
    protected static ShooterSolenoid shooterSolenoid = new ShooterSolenoid();
    protected static ShooterMotors shooterMotors = new ShooterMotors();
    protected static TestMotors testMotors = null;// new TestMotors(); I think we have GroundDrive already doing this.
    protected static ClimberArmSolenoids climberArmSolenoids = null;
    /**
     * Commands.
     */
    public static SmartdashboardJoystick controllerUpdate = new SmartdashboardJoystick();

    public static void init() {
        controllerUpdate.start();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
