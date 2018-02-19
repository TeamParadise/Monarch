
package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import org.usfirst.frc.team1165.robot.commands.RunOnceCommand;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;

/**
 *
 */
public class RotaryLiftIdle extends RunOnceCommand
{
	private RotaryLift mRotaryLift = RotaryLift.getInstance();

	public RotaryLiftIdle()
	{
		requires(mRotaryLift);
	}

	protected void initialize()
	{
		mRotaryLift.disable();
		mRotaryLift.stop();
	}

	protected boolean isFinished()
	{
		return true;
	}
}
