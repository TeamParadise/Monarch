
package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.LinearLift;
import org.usfirst.frc.team1165.util.RunOnceCommand;
import org.usfirst.frc.team1165.util.states.LinearLiftState;

/**
 *
 */
public class LinearLiftCommand extends RunOnceCommand
{
	private LinearLift mLinearLift = LinearLift.getInstance();

	private LinearLiftState state;
	
	/**
	 * <p>
	 * Sets the state of the Linear Lift. States:
	 * </p>
	 * <ol>
	 * <li>Idle is 0 deg</li>
	 * <li>Down is 0 deg</li>
	 * <li>Scale Down is 22.5 deg</li>
	 * <li>Scale Up is 45 deg</li>
	 * </ul>
	 * <br>
	 * 
	 * @param state the desired state of the Linear Lift
	 */
	public LinearLiftCommand(LinearLiftState state)
	{
		this.state = state;
		requires(mLinearLift);
	}

	protected void execute()
	{
		report();
		mLinearLift.set(state);
	}
}
