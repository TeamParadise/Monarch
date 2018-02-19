
package org.usfirst.frc.team1165.robot.commands.claw;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kOff;

import org.usfirst.frc.team1165.robot.commands.StateCommand;
import org.usfirst.frc.team1165.robot.subsystems.Claw;

/**
 *
 */
public class ClawClose extends StateCommand
{
	private Claw mClaw = Claw.getInstance();

	public ClawClose()
	{
		requires(mClaw);
	}

	@Override
	protected void initialize()
	{
		report();
		mClaw.set(kForward);
//		setTimeout(0.6);
	}

	@Override
	protected boolean isFinished()
	{
		return true;
//		return isTimedOut();
	}

//	@Override
//	protected void end()
//	{
//		mClaw.set(kOff);
//	}

}
