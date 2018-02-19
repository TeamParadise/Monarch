
package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.Claw;
import org.usfirst.frc.team1165.util.RunOnceCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 *
 */
public class ClawCommand extends RunOnceCommand
{
	private Claw mClaw = Claw.getInstance();

	private Value state;
	
	/**
	 * <p>
	 * Sets the state of the Claw.
	 * </p>
	 * <ol>
	 * <li>Off is kOff</li>
	 * <li>Close is kForward</li>
	 * <li>Open is kReverse</li>
	 * </ul>
	 * <br>
	 * 
	 * @param state the desired state of the Claw
	 */
	public ClawCommand(Value state)
	{
		this.state = state;
		requires(mClaw);
	}

	protected void execute()
	{
		report();
		mClaw.set(state);
	}
}
