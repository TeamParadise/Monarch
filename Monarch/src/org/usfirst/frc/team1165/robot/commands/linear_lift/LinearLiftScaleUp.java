
package org.usfirst.frc.team1165.robot.commands.linear_lift;

import static org.usfirst.frc.team1165.robot.subsystems.LinearLiftPID.LinearLiftPosition.SCALE_UP;

import org.usfirst.frc.team1165.robot.subsystems.LinearLiftPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LinearLiftScaleUp extends Command
{
	private LinearLiftPID mLinearLiftPID = LinearLiftPID.getInstance();

	public LinearLiftScaleUp()
	{
		requires(mLinearLiftPID);
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
		mLinearLiftPID.setSetpoint(SCALE_UP);
		mLinearLiftPID.enable();
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
