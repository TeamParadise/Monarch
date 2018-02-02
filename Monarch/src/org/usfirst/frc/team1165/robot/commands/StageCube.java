package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StageCube extends Command
{
	private Timer timer1;
	
	private double extendTime;
	private double airToKicker;
	private double taskDone;

	private boolean debug = true;

	public StageCube()
	{
		requires(Robot.pneumatics);
		requires(Robot.shooter);

		timer1 = new Timer();
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		
		extendTime = 0.1;
		airToKicker = 0.2;
		taskDone = 0.3;
		
		// DriverStation.reportWarning("spit", false);
		timer1.start();
		if (debug) DriverStation.reportWarning("Isolate", false);
		Robot.pneumatics.isolateKicker();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		// Robot.shooter.shoot();
		if (timer1.hasPeriodPassed(extendTime))
		{
			extendTime = 9999;
			if (debug) DriverStation.reportWarning("Extend - isolated", false);
			Robot.pneumatics.extendKicker();
		}
		if (timer1.hasPeriodPassed(airToKicker))
		{
			airToKicker = 9999;
			if (debug) DriverStation.reportWarning("Extend", false);
			Robot.pneumatics.airToKicker();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return timer1.hasPeriodPassed(taskDone); // !Robot.oi.spitCubeButton();
	}

	// Called once after isFinished returns true
	protected void end()
	{
		if (debug) DriverStation.reportWarning("Complete", false);
		Robot.shooter.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
