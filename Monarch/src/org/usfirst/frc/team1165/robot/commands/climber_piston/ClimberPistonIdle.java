
package org.usfirst.frc.team1165.robot.commands.climber_piston;

import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberPistonIdle extends Command
{
	private ClimberPiston mClimberPiston = ClimberPiston.getInstance();
	
	public ClimberPistonIdle()
	{
		requires(mClimberPiston);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		mClimberPiston.idle();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
