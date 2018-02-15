
package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import static org.usfirst.frc.team1165.robot.subsystems.RotaryLiftPID.RotaryLiftPosition.IDLE;

import org.usfirst.frc.team1165.robot.subsystems.RotaryLiftPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotaryLiftIdle extends Command
{
	private RotaryLiftPID mRotaryLiftPID = RotaryLiftPID.getInstance();

	public RotaryLiftIdle()
	{
		requires(mRotaryLiftPID);
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
		mRotaryLiftPID.setSetpoint(IDLE);
		mRotaryLiftPID.enable();
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
