
package org.usfirst.frc.team1165.robot.commands.climber_wheels;

import org.usfirst.frc.team1165.robot.subsystems.ClimberWheels;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberWheelsEngage extends Command
{
	private ClimberWheels mClimberWheels = ClimberWheels.getInstance();

	public ClimberWheelsEngage()
	{
		requires(mClimberWheels);
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
		mClimberWheels.engage();
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
