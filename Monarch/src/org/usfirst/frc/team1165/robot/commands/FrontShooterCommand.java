
package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.FrontShooter;
import org.usfirst.frc.team1165.util.RunOnceCommand;
import org.usfirst.frc.team1165.util.states.ShooterState;

/**
 *
 */
public class FrontShooterCommand extends RunOnceCommand
{
	private FrontShooter mFrontShooter = FrontShooter.getInstance();

	private ShooterState state;
	
	/**
	 * <p>
	 * Sets the state of the Front Shooter.
	 * </p>
	 * <ol>
	 * <li>Idle is Idle</li>
	 * <li>Intake is Intake</li>
	 * <li>Eject is Eject</li>
	 * <li>Twist Right is (Eject, Intake)</li>
	 * <li>Twist Left is (Intake, Eject)</li>
	 * </ul>
	 * <br>
	 * 
	 * @param state the desired state of the Front Shooter
	 */
	public FrontShooterCommand(ShooterState state)
	{
		this.state = state;	
		requires(mFrontShooter);
	}

	protected void execute()
	{
		report();
		mFrontShooter.set(state);
	}
}
