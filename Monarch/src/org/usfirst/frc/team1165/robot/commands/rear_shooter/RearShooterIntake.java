
package org.usfirst.frc.team1165.robot.commands.rear_shooter;

import org.usfirst.frc.team1165.robot.subsystems.RearShooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RearShooterIntake extends Command
{
	private RearShooter mRearShooter = RearShooter.getInstance();
	
	public RearShooterIntake()
	{
		requires(mRearShooter);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		mRearShooter.intake();
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
