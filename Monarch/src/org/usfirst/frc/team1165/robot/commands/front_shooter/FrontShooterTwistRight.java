
package org.usfirst.frc.team1165.robot.commands.front_shooter;

import org.usfirst.frc.team1165.robot.subsystems.FrontShooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FrontShooterTwistRight extends Command
{
	private FrontShooter mFrontShooter = FrontShooter.getInstance();

	public FrontShooterTwistRight()
	{
		requires(mFrontShooter);
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
		mFrontShooter.twistRight();
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
