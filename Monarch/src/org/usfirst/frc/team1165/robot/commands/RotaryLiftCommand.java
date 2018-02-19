
package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;
import org.usfirst.frc.team1165.util.RunOnceCommand;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

/**
 *
 */
public class RotaryLiftCommand extends RunOnceCommand
{
	private RotaryLift mRotaryLift = RotaryLift.getInstance();

	private RotaryLiftState state;
	
	/**
	 * <p>
	 * Sets the state of the Rotary Lift. States:
	 * </p>
	 * <ol>
	 * <li>Idle is 0 in</li>
	 * <li>Intake is 0 in</li>
	 * <li>Switch is 100 in</li>
	 * <li>Scale Down is 200 in</li>
	 * <li>Scale Up is 300 in</li>
	 * </ul>
	 * <br>
	 * 
	 * @param state the desired state of the Rotary Lift
	 */
	public RotaryLiftCommand(RotaryLiftState state)
	{
		this.state = state;
		requires(mRotaryLift);
	}

	protected void execute()
	{
		report();
		mRotaryLift.set(state);
	}
}
