
package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.RearShooter;
import org.usfirst.frc.team1165.util.RunOnceCommand;
import org.usfirst.frc.team1165.util.states.ShooterState;

/**
 *
 */
public class RearShooterCommand extends RunOnceCommand
{
	private RearShooter mRearShooter = RearShooter.getInstance();

	private ShooterState state;
	
	/**
	 * <p>
	 * Sets the state of the Rear Shooter.
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
	 * @param state the desired state of the Rear Shooter
	 */
	public RearShooterCommand(ShooterState state)
	{
		this.state = state;	
		requires(mRearShooter);
	}

	protected void execute()
	{
		report();
		mRearShooter.set(state);
	}
}
