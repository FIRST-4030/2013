package org.ingrahamrobotics.robot2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.ingrahamrobotics.robot2013.subsystems.Climber10PointSolenoids;
import org.ingrahamrobotics.robot2013.subsystems.ClimberMotors;
import org.ingrahamrobotics.robot2013.subsystems.Compressor;
import org.ingrahamrobotics.robot2013.subsystems.FrisbeeHolderSolenoids;
import org.ingrahamrobotics.robot2013.subsystems.GroundDrive;
import org.ingrahamrobotics.robot2013.subsystems.PressureSwitch;
import org.ingrahamrobotics.robot2013.subsystems.ShooterMotors;
import org.ingrahamrobotics.robot2013.subsystems.ShooterSolenoids;
import org.ingrahamrobotics.robot2013.variablestores.dynamic.DVstShooterMotors;
import org.ingrahamrobotics.robot2013.vstj.VstJ;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system.
 */
public abstract class CommandBase extends Command {

    /**
     * SubSystems.
     */
    protected static final Compressor compressor = new Compressor();
    protected static final ClimberMotors climberMotors = new ClimberMotors();
    protected static final PressureSwitch pressureSwitch = new PressureSwitch();
    protected static final GroundDrive groundDrive = new GroundDrive();
    protected static final ShooterSolenoids shooterSolenoids = new ShooterSolenoids();
    protected static final ShooterMotors shooterMotors = new ShooterMotors();
    protected static final Climber10PointSolenoids climber10PointSolenoids = new Climber10PointSolenoids();
    protected static final FrisbeeHolderSolenoids frisbeeHolderSolenoids = new FrisbeeHolderSolenoids();
    /**
     * Commands.
     */
    protected static final DashboardValueRefresh dashboardValueRefresh = new DashboardValueRefresh();

    /**
     * Shooter Motor Handler.
     */
    protected static final DVstShooterMotors dVstShooterMotors = new DVstShooterMotors(shooterMotors);

    public static void init() {
        //Commands
        dashboardValueRefresh.start();
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
        //Shooter Motor Handler
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
