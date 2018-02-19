package org.usfirst.frc.team1165.robot.commands.drive;

import org.usfirst.frc.team1165.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1165.util.drivers.OperatorInterface;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command
{
	private DriveTrain mDriveTrain = DriveTrain.getInstance();
	
	public DriveWithJoystick()
	{
		requires(mDriveTrain);
	}

	@Override
	protected void initialize()
	{
	}

	@Override
	protected void execute()
	{
		mDriveTrain.arcadeDrive(OperatorInterface.getY(), OperatorInterface.getTwist());
//		mDriveTrain.tankDrive(OperatorInterface.getY(), OperatorInterface.getTwist());

//		mDriveTrain.arcadeDrive(Robot.mOI.getDampedX(), Robot.mOI.getDampedTwist()); // for switch
//		mDriveTrain.tankDrive(Robot.mOI.getLeftY(), Robot.mOI.getLeftY());

//		double twist = 0;
//
//		if(Robot.mOI.getButtonX())
//			twist = 0.5;
//		if(Robot.mOI.getButtonB())
//			twist = -0.5;
//
//		mDriveTrain.arcadeDrive(Robot.mOI.getLeftY(), twist);
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}

	@Override
	protected void end()
	{
		mDriveTrain.tankDrive(0, 0);
	}

	@Override
	protected void interrupted()
	{
		end();
	}
}
