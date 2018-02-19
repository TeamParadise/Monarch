package org.usfirst.frc.team1165.robot.subsystems;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.drive.DriveWithJoystick;
import org.usfirst.frc.team1165.util.StateMachine;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends StateMachine
{
	private static final DriveTrain mInstance = new DriveTrain();

	private WPI_TalonSRX mRightMaster = new WPI_TalonSRX(RobotMap.RIGHT_MASTER_DRIVE_PORT);
//	private WPI_TalonSRX mRightSlave = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE_DRIVE_PORT);
	private WPI_TalonSRX mLeftMaster = new WPI_TalonSRX(RobotMap.LEFT_MASTER_DRIVE_PORT);
//	private WPI_TalonSRX mLeftSlave = new WPI_TalonSRX(RobotMap.LEFT_SLAVE_DRIVE_PORT);

	private DifferentialDrive mDrive = new DifferentialDrive(mLeftMaster, mRightMaster);

	protected DriveTrain()
	{
//		mRightSlave.follow(mRightMaster);
//		mLeftSlave.follow(mLeftMaster);

//		mRightSlave.setInverted(true);
//		mLeftSlave.setInverted(true);
		
//		mRightSlave.setInverted(true);
//		mLeftSlave.setInverted(true);

//		mRightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	}

	public static DriveTrain getInstance()
	{
		return mInstance;
	}

	/**
	 * Arcade drive method for differential drive platform. The calculated
	 * values will be squared to decrease sensitivity at low speeds.
	 *
	 * @param xSpeed
	 *            The robot's speed along the X axis [-1.0..1.0]. Forward is
	 *            positive.
	 * @param zRotation
	 *            The robot's rotation rate around the Z axis [-1.0..1.0].
	 *            Clockwise is positive.
	 */
	public void arcadeDrive(double speed, double twist)
	{
		mDrive.arcadeDrive(speed, twist);
	}

	/**
	 * Tank drive method for differential drive platform. The calculated values
	 * will be squared to decrease sensitivity at low speeds.
	 *
	 * @param leftSpeed
	 *            The robot's left side speed along the X axis [-1.0..1.0].
	 *            Forward is positive.
	 * @param rightSpeed
	 *            The robot's right side speed along the X axis [-1.0..1.0].
	 *            Forward is positive.
	 */
	public void tankDrive(double leftSpeed, double rightSpeed)
	{
		mDrive.tankDrive(leftSpeed, rightSpeed);
//		mDrive.tankDrive(Math.pow(leftSpeed, 3), rightSpeed, false);
	}

	public double getPosition()
	{
		return mRightMaster.getSensorCollection().getQuadraturePosition();
	}

	public double getVelocity()
	{
		return mRightMaster.getSensorCollection().getQuadratureVelocity();
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new DriveWithJoystick());
	}

	@Override
	public List<Command> getCommands()
	{
		return Arrays.asList(new DriveWithJoystick());
	}

	public void report()
	{
		SmartDashboard.putNumber("DriveTrain Right Master", mRightMaster.get());
		SmartDashboard.putNumber("DriveTrain Left Master", mLeftMaster.get());

//		SmartDashboard.putNumber("DriveTrain Right Position", getPosition());
//		SmartDashboard.putNumber("DriveTrain Right Velocity", getVelocity());
	}
}