
package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston;
import org.usfirst.frc.team1165.util.RunOnceCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 *
 */
public class ClimberPistonCommand extends RunOnceCommand
{
	private ClimberPiston mClimberPiston = ClimberPiston.getInstance();

	private Value state;
	
	/**
	 * <p>
	 * Sets the state of the Climber Piston.
	 * </p>
	 * <ol>
	 * <li>Off is kOff</li>
	 * <li>Extend is kForward</li>
	 * <li>Retract is kReverse</li>
	 * </ul>
	 * <br>
	 * 
	 * @param state the desired state of the Climber Piston
	 */
	public ClimberPistonCommand(Value state)
	{
		this.state = state;
		requires(mClimberPiston);
	}

	protected void execute()
	{
		report();
		mClimberPiston.set(state);
	}
}
