
package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1165.robot.Robot;

/**
 *
 */
public class Intake extends Command
{

	public Intake()
	{
		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.shooter.intake();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return !Robot.oi.intakeButton();
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.shooter.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
