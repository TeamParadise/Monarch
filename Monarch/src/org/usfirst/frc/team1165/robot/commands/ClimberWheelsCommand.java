
package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.ClimberWheels;
import org.usfirst.frc.team1165.util.RunOnceCommand;

/**
 *
 */
public class ClimberWheelsCommand extends RunOnceCommand
{
	private ClimberWheels mClimberWheels = ClimberWheels.getInstance();

	private boolean state;
	
	/**
	 * <p>
	 * Sets the state of the Climber Wheels.
	 * </p>
	 * <ol>
	 * <li>Engage is true</li>
	 * <li>Disengage is false</li>
	 * </ul>
	 * <br>
	 * 
	 * @param state the desired state of the Climber Wheels
	 */
	public ClimberWheelsCommand(boolean state)
	{
		this.state = state;
		requires(mClimberWheels);
	}

	protected void execute()
	{
		report();
		mClimberWheels.set(state);
	}
}
