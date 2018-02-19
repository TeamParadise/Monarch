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
	protected void execute()
	{
		mDriveTrain.arcadeDrive(OperatorInterface.getY(), OperatorInterface.getTwist());
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

}
