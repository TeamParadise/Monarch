
package org.usfirst.frc.team1165.robot.commands.rear_shooter;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.RearShooter;

/**
 *
 */
public class RearShooterIntake extends StateCommand
{
	private RearShooter mRearShooter = RearShooter.getInstance();

	public RearShooterIntake()
	{
		requires(mRearShooter);
	}

	protected void initialize()
	{
		report();
	}

	protected void execute()
	{
		mRearShooter.intake();
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
