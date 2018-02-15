
package org.usfirst.frc.team1165.robot.commands.claw;

import org.usfirst.frc.team1165.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawClose extends Command
{
	private Claw mClaw = Claw.getInstance();

	public ClawClose()
	{
		requires(mClaw);
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
		mClaw.close();
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
