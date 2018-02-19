
package org.usfirst.frc.team1165.robot.commands.linear_lift;

import static org.usfirst.frc.team1165.util.LinearLiftPosition.INTAKE;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;

import edu.wpi.first.wpilibj.DriverStation;

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
		mLinearLift.set(INTAKE);
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
		DriverStation.reportWarning("End Position: "+ mLinearLift.getLiftPosition(), false);
		mLinearLift.disable();
	}
}
