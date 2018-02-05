package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpitCube extends Command
{
	private Timer timer1;

	public SpitCube()
	{
		requires(Robot.pneumatics);
		requires(Robot.shooter);

		timer1 = new Timer();
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		timer1.start();
		Robot.pneumatics.isolateKicker();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		// Robot.shooter.shoot();
		if (timer1.hasPeriodPassed(0.1))
		{
			Robot.pneumatics.airToKicker();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return timer1.hasPeriodPassed(0.175);
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
