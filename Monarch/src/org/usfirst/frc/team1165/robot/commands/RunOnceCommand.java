
package org.usfirst.frc.team1165.robot.commands;

/**
 * Subclasses need to define {@link #initialize} and {@link #end}.
 */
public abstract class RunOnceCommand extends StateCommand
{
	@Override
	protected void initialize()
	{
		report();
	}

	@Override
	protected boolean isFinished()
	{
		return true;
	}
}