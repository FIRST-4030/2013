package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.subsystems.*;
import edu.wpi.first.wpilibj.templates.variablestores.dynamic.DVstShooterMotors;
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
    protected static ClimberMotors climber;
    protected static PressureSwitch pressureSwitch;
    protected static GroundDrive groundDrive;
    protected static ClimberLimitSwitch climberLimitSwitch;
    protected static ShooterSolenoids shooterSolenoids;
    protected static ShooterMotors shooterMotors;
    protected static LadderPushSolenoids ladderPushSolenoids;
    protected static Climb10PointSolenoids climber10PointSolenoids;
    protected static FrisbeeHolderSolenoids frisbeeHolderSolenoids;
    /**
     * Commands.
     */
    protected static DashboardValueRefresh dashboardValueRefresh;
    /**
     * Shooter Motor Handler.
     */
    protected static DVstShooterMotors dVstShooterMotors;

    public static void init() {
        //Commands
        dashboardValueRefresh = new DashboardValueRefresh();
        dashboardValueRefresh.start();
        //SubSystems:CompressorThings:
        compressor = new Compressor();
        pressureSwitch = new PressureSwitch();
        //SubSystems:Solenoids:
        shooterSolenoids = new ShooterSolenoids();
        ladderPushSolenoids = new LadderPushSolenoids();
        climber10PointSolenoids = new Climb10PointSolenoids();
        frisbeeHolderSolenoids = new FrisbeeHolderSolenoids();
        //SubSystems:Switches:
        climberLimitSwitch = new ClimberLimitSwitch();
        //SubSystems:Motors:
        climber = new ClimberMotors();
        groundDrive = new GroundDrive();
        shooterMotors = new ShooterMotors();
        //Button Commands
        VstJ.getGroundDriveFastTurnLeftButton().whenPressed(new FastTurnRobotDriveLeft());
        VstJ.getGroundDriveFastTurnRightButton().whenPressed(new FastTurnRobotDriveRight());
        VstJ.getShooterSolenoidPushButton().whenPressed(new RunShooterSolenoids());
        VstJ.getShooterMotorOffButton().whenPressed(new ShooterMotorSpeedOff());
        VstJ.getShooterMotorOnButton().whenPressed(new ShooterMotorSpeedOn());
        VstJ.getFrisbeeHolderExtendButton().whenPressed(new FrisbeeHolderSolenoidsExtend());
        VstJ.getFrisbeeHolderRetractButton().whenPressed(new FrisbeeHolderSolenoidsRetract());
        VstJ.getClimber10PointSolenoidsExtendButton().whenPressed(new Climber10PointSolenoidsExtend());
        VstJ.getClimber10PointSolenoidsRetractButton().whenPressed(new Climber10PointSolenoidsRetract());
        VstJ.getClimberArmSolenoidStartExtendButton().whenPressed(new ExtendClimberArmSolenoids());
        //Shooter Motor Handler
        dVstShooterMotors = new DVstShooterMotors(shooterMotors);
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