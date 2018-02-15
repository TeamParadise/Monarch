
package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import static org.usfirst.frc.team1165.robot.subsystems.RotaryLiftPID.RotaryLiftPosition.DOWN;

import org.usfirst.frc.team1165.robot.subsystems.RotaryLiftPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotaryLiftDown extends Command
{
	private RotaryLiftPID mRotaryLiftPID = RotaryLiftPID.getInstance();

	public RotaryLiftDown()
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
		mRotaryLiftPID.setSetpoint(DOWN);
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
