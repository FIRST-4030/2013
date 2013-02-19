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
    protected static Compressor compressor;
    protected static Camera mainCamera;
    protected static Climber climber;
    protected static PressureSwitch pressureSwitch;
    protected static GroundDrive groundDrive;
    protected static ClimberLimitSwitch climberLimitSwitch;
    protected static ShooterSolenoid shooterSolenoid;
    protected static ShooterMotors shooterMotors;
    protected static ClimberArmSolenoids climberArmSolenoids;
    protected static ClimberWedgeSolenoid climberWedgeSolenoid;
    protected static FrisbeeDumperSolenoid frisbeeDumperSolenoid;
    /**
     * Commands.
     */
    protected static DashboardValueRefresh dashboardValueRefresh;

    public static void init() {
        dashboardValueRefresh = new DashboardValueRefresh();
        dashboardValueRefresh.start();
        mainCamera = new Camera();
        pressureSwitch = new PressureSwitch();
        compressor = new Compressor();
        climberLimitSwitch = new ClimberLimitSwitch();
        climber = new Climber();
        shooterSolenoid = new ShooterSolenoid();
        shooterMotors = new ShooterMotors();
        groundDrive = new GroundDrive();
        climberArmSolenoids = new ClimberArmSolenoids();
        climberWedgeSolenoid = new ClimberWedgeSolenoid();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }

    protected final void interrupted() {
        end();
    }
}
