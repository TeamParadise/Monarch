
package org.usfirst.frc.team1165.robot.commands.claw;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.Claw;

/**
 *
 */
public class ClawOpen extends StateCommand
{
	private Claw mClaw = Claw.getInstance();

	public ClawOpen()
	{
		requires(mClaw);
	}

	@Override
	protected void initialize()
	{
		report();
		mClaw.set(kReverse);
	}

	@Override
	protected boolean isFinished()
	{
		return true;
	}
}
