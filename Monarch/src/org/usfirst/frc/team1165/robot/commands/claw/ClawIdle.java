
package org.usfirst.frc.team1165.robot.commands.claw;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kOff;

import org.usfirst.frc.team1165.robot.commands.RunOnceCommand;
import org.usfirst.frc.team1165.robot.subsystems.Claw;

/**
 *
 */
public class ClawIdle extends RunOnceCommand
{
	private Claw mClaw = Claw.getInstance();

	public ClawIdle()
	{
		requires(mClaw);
	}

	@Override
	protected void execute()
	{
		report();
		mClaw.set(kOff);
	}

}
