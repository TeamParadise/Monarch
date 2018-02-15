
package org.usfirst.frc.team1165.robot.commands.rear_shooter;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.RearShooter;

/**
 *
 */
public class RearShooterIdle extends StateCommand
{
	private RearShooter mRearShooter = RearShooter.getInstance();

	public RearShooterIdle()
	{
		requires(mRearShooter);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		report();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		mRearShooter.idle();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		mRearShooter.idle();
	}
}
