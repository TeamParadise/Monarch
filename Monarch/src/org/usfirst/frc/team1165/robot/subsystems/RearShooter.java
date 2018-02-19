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
public class RearShooter extends StateMachine
{
	private static final RearShooter mInstance = new RearShooter();

	private WPI_TalonSRX mRearRightMotor = new WPI_TalonSRX(RobotMap.REAR_RIGHT_SHOOTER_PORT);
	private WPI_TalonSRX mRearLeftMotor = new WPI_TalonSRX(RobotMap.REAR_LEFT_SHOOTER_PORT);

	protected RearShooter()
	{
		// mRearRightMotor.setInverted(true); // commented out as a test
	}

	public synchronized static RearShooter getInstance()
	{
		return mInstance;
	}

	public void set(ShooterState state)
	{
		mRearRightMotor.set(state.getRight());
		mRearLeftMotor.set(state.getLeft());
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber("Rear Right Shooter", mRearRightMotor.get());
		SmartDashboard.putNumber("Rear Left Shooter", mRearLeftMotor.get());
	}

}