
package org.usfirst.frc.team1165.robot.commands.linear_lift;

import static org.usfirst.frc.team1165.robot.subsystems.LinearLift.LinearLiftPosition.IDLE;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;

/**
 *
 */
public class LinearLiftIdle extends StateCommand
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
		mLinearLift.setSetpoint(IDLE);
		mLinearLift.enable();
	}

	@Override
	protected boolean isFinished()
	{
		return mLinearLift.onTarget();
	}

	@Override
	protected void end()
	{
		mLinearLift.disable();
	}
}
