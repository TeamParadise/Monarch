
package org.usfirst.frc.team1165.robot.commands.climber_isolate;

import org.usfirst.frc.team1165.robot.subsystems.ClimberIsolate;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberIsolateIdle extends Command
{
	private ClimberIsolate mClimberIsolate = ClimberIsolate.getInstance();

	public ClimberIsolateIdle()
	{
		requires(mClimberIsolate);
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		mClimberIsolate.isolate();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}
}
