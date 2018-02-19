package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.util.StateMachine;
import org.usfirst.frc.team1165.util.states.ShooterState;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class FrontShooter extends StateMachine
{
	private static final FrontShooter mInstance = new FrontShooter();

	private WPI_TalonSRX mFrontRightMotor = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_SHOOTER_PORT);
	private WPI_TalonSRX mFrontLeftMotor = new WPI_TalonSRX(RobotMap.FRONT_LEFT_SHOOTER_PORT);

	protected FrontShooter()
	{
		mFrontRightMotor.setInverted(true);
	}

	public synchronized static FrontShooter getInstance()
	{
		return mInstance;
	}

	public void set(ShooterState state)
	{
		mFrontRightMotor.set(state.getRight());
		mFrontLeftMotor.set(state.getLeft());
	}
	
	@Override
	public void report()
	{
		SmartDashboard.putNumber("Front Right Shooter", mFrontRightMotor.get());
		SmartDashboard.putNumber("Front Left Shooter", mFrontLeftMotor.get());
	}

}