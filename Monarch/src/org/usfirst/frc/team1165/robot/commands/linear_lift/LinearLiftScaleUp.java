
package org.usfirst.frc.team1165.robot.commands.linear_lift;

import static org.usfirst.frc.team1165.util.LinearLiftPosition.SCALE_UP;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;

import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 */
public class LinearLiftScaleUp extends StateCommand
{
	private LinearLift mLinearLift = LinearLift.getInstance();

	public LinearLiftScaleUp()
	{
		requires(mLinearLift);
	}

	@Override
	protected void initialize()
	{
		report();
		mLinearLift.setSetpoint(SCALE_UP);
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
