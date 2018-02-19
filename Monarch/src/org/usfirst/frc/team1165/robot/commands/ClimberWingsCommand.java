
package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.ClimberWings;
import org.usfirst.frc.team1165.util.RunOnceCommand;

/**
 *
 */
public class ClimberWingsCommand extends RunOnceCommand
{
	private ClimberWings mClimberWings = ClimberWings.getInstance();

	private boolean state;
	
	/**
	 * <p>
	 * Sets the state of the Climber Wings.
	 * </p>
	 * <ol>
	 * <li>Engage is true</li>
	 * <li>Disengage is false</li>
	 * </ul>
	 * <br>
	 * 
	 * @param state the desired state of the Climber Wings
	 */
	public ClimberWingsCommand(boolean state)
	{
		this.state = state;
		requires(mClimberWings);
	}

	protected void execute()
	{
		report();
		mClimberWings.set(state);
	}
}
