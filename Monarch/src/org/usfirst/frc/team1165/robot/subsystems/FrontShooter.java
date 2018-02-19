package org.usfirst.frc.team1165.robot.subsystems;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterEject;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterIdle;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterIntake;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterTwistLeft;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterTwistRight;
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

	public void set(MotorPower power) {
		mFrontRightMotor.set(power.get());
		mFrontLeftMotor.set(power.get());
	}

	public void set(MotorPower rightPower, MotorPower leftPower) {
		mFrontRightMotor.set(rightPower.get());
		mFrontLeftMotor.set(leftPower.get());
	}
	
	public void idle()
	{
		mFrontRightMotor.set(0);
		mFrontLeftMotor.set(0);
	}

	public void intake()
	{
		mFrontRightMotor.set(1);
		mFrontLeftMotor.set(1);
	}

	public void eject()
	{
		mFrontRightMotor.set(-1);
		mFrontLeftMotor.set(-1);
	}

	public void twistLeft()
	{
		mFrontRightMotor.set(-1);
		mFrontLeftMotor.set(1);
	}

	public void twistRight()
	{
		mFrontRightMotor.set(1);
		mFrontLeftMotor.set(-1);
	}

	@Override
	public List<Command> getCommands()
	{
		return Arrays.asList(
			new FrontShooterIdle(),
			new FrontShooterIntake(),
			new FrontShooterEject(),
			new FrontShooterTwistRight(),
			new FrontShooterTwistLeft());
	}
	
	@Override
	public void report()
	{
		SmartDashboard.putNumber("Front Right Shooter", mFrontRightMotor.get());
		SmartDashboard.putNumber("Front Left Shooter", mFrontLeftMotor.get());
	}

}