
package org.usfirst.frc.team1165.robot.commands.linear_lift;

import static org.usfirst.frc.team1165.robot.subsystems.LinearLift.LinearLiftPosition.INTAKE;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;

/**
 *
 */
public class LinearLiftIntake extends StateCommand
{
	private LinearLift mLinearLift = LinearLift.getInstance();

	public LinearLiftIntake()
	{
		requires(mLinearLift);
	}

	@Override
	protected void initialize()
	{
		report();
		mLinearLift.setSetpoint(INTAKE);
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
