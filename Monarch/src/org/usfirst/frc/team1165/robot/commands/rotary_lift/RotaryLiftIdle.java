
package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;

/**
 *
 */
public class RotaryLiftIdle extends StateCommand
{
	private RotaryLift mRotaryLift = RotaryLift.getInstance();

	public RotaryLiftIdle()
	{
		requires(mRotaryLift);
	}

	protected void initialize()
	{
		mRotaryLift.disable();
	}

	protected void execute()
	{

	}

	protected boolean isFinished()
	{
		return true;
	}
}
