
package org.usfirst.frc.team1165.robot.commands.rear_shooter;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.RearShooter;

/**
 *
 */
public class RearShooterEject extends StateCommand
{
	private RearShooter mRearShooter = RearShooter.getInstance();

	public RearShooterEject()
	{
		requires(mRearShooter);
	}

	protected void initialize()
	{
		report();
	}

	protected void execute()
	{
		mRearShooter.eject();
	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
		mRearShooter.idle();
	}

}
