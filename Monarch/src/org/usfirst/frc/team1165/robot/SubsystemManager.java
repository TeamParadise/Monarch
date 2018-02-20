package org.usfirst.frc.team1165.robot;

import java.util.ArrayList;

import org.usfirst.frc.team1165.robot.commands.ClawCommand;
import org.usfirst.frc.team1165.robot.commands.ClimberPistonCommand;
import org.usfirst.frc.team1165.robot.commands.ClimberWheelsCommand;
import org.usfirst.frc.team1165.robot.commands.ClimberWingsCommand;
import org.usfirst.frc.team1165.robot.commands.FrontShooterCommand;
import org.usfirst.frc.team1165.robot.commands.LinearLiftCommand;
import org.usfirst.frc.team1165.robot.commands.RearShooterCommand;
import org.usfirst.frc.team1165.robot.commands.RotaryLiftCommand;
import org.usfirst.frc.team1165.util.Stateful;
import org.usfirst.frc.team1165.util.states.LinearLiftState;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;
import org.usfirst.frc.team1165.util.states.ShooterState;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class SubsystemManager
{
	private static final SubsystemManager mInstance = new SubsystemManager();
	
	private ArrayList<Stateful> mSubsystems = new ArrayList<Stateful>();

	private boolean mClaw = false;
	private boolean mClimberPiston = false;
	private boolean mClimberWheels = false;
	private boolean mClimberWings = false;
	private boolean mFrontShooter = false;
	private boolean mLinearLift = false;
	private boolean mRearShooter = false;
	private boolean mRotaryLift = false;
	
	private SendableChooser<LinearLiftState> mLinearState = new SendableChooser<>();
	private SendableChooser<RotaryLiftState> mRotaryState = new SendableChooser<>();
	private SendableChooser<Value> mDoubleSolenoidState = new SendableChooser<>();
	private SendableChooser<Boolean> mSingleSolenoidState = new SendableChooser<>();
	private SendableChooser<ShooterState> mShooterState = new SendableChooser<>();
	
	
	
	protected SubsystemManager()
	{
		if(mLinearLift)
		{
			mLinearState.addDefault("Idle", LinearLiftState.IDLE);
			mLinearState.addObject("Intake", LinearLiftState.INTAKE);
			mLinearState.addObject("Switch", LinearLiftState.SWITCH);
			mLinearState.addObject("Scale Down", LinearLiftState.SCALE_DOWN);
			mLinearState.addObject("Scale Up", LinearLiftState.SCALE_UP);
		}
		if(mRotaryLift)
		{
			mRotaryState.addDefault("Idle", RotaryLiftState.IDLE);
			mRotaryState.addObject("Intake", RotaryLiftState.DOWN);
			mRotaryState.addObject("Scale Down", RotaryLiftState.SCALE_DOWN);
			mRotaryState.addObject("Scale Up", RotaryLiftState.SCALE_UP);
		}
		if(mClaw || mClimberPiston)
		{
			mDoubleSolenoidState.addDefault("Idle", Value.kOff);
			mDoubleSolenoidState.addObject("Intake", Value.kForward);
			mDoubleSolenoidState.addObject("Scale Down", Value.kReverse);
		}
		if(mFrontShooter || mRearShooter)
		{
			mShooterState.addDefault("Idle", ShooterState.IDLE);
			mShooterState.addObject("Intake", ShooterState.INTAKE);
			mShooterState.addObject("Intake", ShooterState.TWIST_LEFT);
			mShooterState.addObject("Scale Down", ShooterState.TWIST_RIGHT);
			mShooterState.addObject("Scale Down", ShooterState.EJECT);
		}
		if(mClimberWheels || mClimberWings)
		{
			mSingleSolenoidState.addDefault("True", true);
			mSingleSolenoidState.addObject("False", false);
		}
		
		SmartDashboard.putData(mLinearState);
		SmartDashboard.putData(mRotaryState);
		SmartDashboard.putData(mDoubleSolenoidState);
		SmartDashboard.putData(mShooterState);
	}
	
	public static SubsystemManager getInstance() {
		return mInstance;
	}

	public void add(Stateful subsystem)
	{
		mSubsystems.add(subsystem);
	}

	public void putCommands()
	{
		if(mClaw) SmartDashboard.putData(new ClawCommand(mDoubleSolenoidState.getSelected()));
		if(mClimberPiston) SmartDashboard.putData(new ClimberPistonCommand(mDoubleSolenoidState.getSelected()));
		if(mClimberWheels) SmartDashboard.putData(new ClimberWheelsCommand(mSingleSolenoidState.getSelected()));
		if(mClimberWings) SmartDashboard.putData(new ClimberWingsCommand(mSingleSolenoidState.getSelected()));

		if(mFrontShooter) SmartDashboard.putData(new FrontShooterCommand(mShooterState.getSelected()));
		if(mRearShooter) SmartDashboard.putData(new RearShooterCommand(mShooterState.getSelected()));

		if(mLinearLift) SmartDashboard.putData(new LinearLiftCommand(mLinearState.getSelected()));
		if(mRotaryLift) SmartDashboard.putData(new RotaryLiftCommand(mRotaryState.getSelected()));
	}

	public void report()
	{
		mSubsystems.forEach((subsystem) -> {
			SmartDashboard.putData((Sendable) subsystem);
			subsystem.report();
		});
	}

}