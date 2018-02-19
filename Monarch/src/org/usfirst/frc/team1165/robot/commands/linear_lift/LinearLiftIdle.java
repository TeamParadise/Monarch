
package org.usfirst.frc.team1165.robot.commands.linear_lift;

import org.usfirst.frc.team1165.robot.commands.RunOnceCommand;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;

/**
 *
 */
public class LinearLiftIdle extends RunOnceCommand
{
	private LinearLift mLinearLift = LinearLift.getInstance();

	public LinearLiftIdle()
	{
		requires(mLinearLift);
	}

	@Override
	protected void initialize()
	{
		report();
		mLinearLift.disable();
	}
}