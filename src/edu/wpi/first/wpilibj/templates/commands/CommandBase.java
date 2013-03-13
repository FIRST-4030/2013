package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.subsystems.*;
import edu.wpi.first.wpilibj.templates.vstj.VstJ;

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
    protected static ShooterSolenoids shooterSolenoids;
    protected static ShooterMotors shooterMotors;
    protected static ClimberArmSolenoids climberArmSolenoids;
    protected static ClimberWedgeSolenoids climberWedgeSolenoids;
    protected static FrisbeeDumperSolenoids frisbeeDumperSolenoids;
    protected static CameraServo cameraServo;
    /**
     * Commands.
     */
    protected static DashboardValueRefresh dashboardValueRefresh;
    protected static ReadLimitSwitches readLimitSwitches;

    public static void init() {
        //Commands
        dashboardValueRefresh = new DashboardValueRefresh();
        dashboardValueRefresh.start();
        //SubSystems:CompressorThings:
        compressor = new Compressor();
        pressureSwitch = new PressureSwitch();
        //SubSystems:Solenoids:
        shooterSolenoids = new ShooterSolenoids();
        climberArmSolenoids = new ClimberArmSolenoids();
        climberWedgeSolenoids = new ClimberWedgeSolenoids();
        frisbeeDumperSolenoids = new FrisbeeDumperSolenoids();
        //SubSystems:Switches:
        climberLimitSwitch = new ClimberLimitSwitch();
        //SubSystems:Motors:
        climber = new Climber();
        groundDrive = new GroundDrive();
        cameraServo = new CameraServo();
        shooterMotors = new ShooterMotors();
        //SubSystems:OtherThings:
        mainCamera = new Camera();
        //Button Commands
        VstJ.getGroundDriveFastTurnLeftButton().whenPressed(new FastTurnRobotDriveLeft());
        VstJ.getGroundDriveFastTurnRightButton().whenPressed(new FastTurnRobotDriveRight());
        VstJ.getShooterSolenoidPushButton().whenPressed(new RunShooterSolenoid());
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
