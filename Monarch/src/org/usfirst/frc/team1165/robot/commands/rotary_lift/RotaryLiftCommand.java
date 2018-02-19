
package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;
import org.usfirst.frc.team1165.util.RotaryLiftPosition;

import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 */
public class RotaryLiftCommand extends StateCommand
{
	private RotaryLift mRotaryLift = RotaryLift.getInstance();

	public RotaryLiftCommand()
	{
		requires(mRotaryLift);
	}

	protected void initialize(RotaryLiftPosition position)
	{
		mRotaryLift.setSetpoint(position);
		mRotaryLift.enable();
	}

	protected void execute()
	{

	}

	protected boolean isFinished()
	{
		return mRotaryLift.onTarget();
	}

	protected void end()
	{
		if (isFinished())
			DriverStation.reportError("On Target: " + mRotaryLift.getLiftPosition(), false);

		mRotaryLift.disable();
		mRotaryLift.stop();
	}
}
