package org.usfirst.frc.team1165.robot.subsystems;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterEject;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIdle;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIntake;
import org.usfirst.frc.team1165.util.MotorPower;
import org.usfirst.frc.team1165.util.StateMachine;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
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

	public void set(MotorPower power)
	{
		set(power, power);
	}

	public void set(MotorPower rightPower, MotorPower leftPower)
	{
		mRearRightMotor.set(rightPower.get());
		mRearLeftMotor.set(leftPower.get());
	}

	public void idle()
	{
		mRearRightMotor.set(0);
		mRearLeftMotor.set(0);
	}

	public void intake()
	{
		mRearRightMotor.set(1);
		mRearLeftMotor.set(1);
	}

	public void eject()
	{
		mRearRightMotor.set(-1);
		mRearLeftMotor.set(-1);
	}

	@Override
	public List<Command> getCommands()
	{
		return Arrays.asList(new RearShooterIdle(), new RearShooterIntake(), new RearShooterEject());
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber("Rear Right Shooter", mRearRightMotor.get());
		SmartDashboard.putNumber("Rear Left Shooter", mRearLeftMotor.get());
	}

}