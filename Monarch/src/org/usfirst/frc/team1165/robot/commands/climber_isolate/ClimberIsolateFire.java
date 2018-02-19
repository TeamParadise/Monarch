
package org.usfirst.frc.team1165.robot.commands.climber_isolate;

import org.usfirst.frc.team1165.robot.subsystems.ClimberIsolate;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberIsolateFire extends Command
{
	private ClimberIsolate mClimberIsolate = ClimberIsolate.getInstance();

	public ClimberIsolateFire()
	{
		requires(mClimberIsolate);
	}

	protected void initialize()
	{
		mClimberIsolate.set(kForward);
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
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
