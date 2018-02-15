package org.usfirst.frc.team1165.util;

import java.util.List;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * Common interface for all State Machines.
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface Stateful
{
	/**
	 * Gets a list of States(Commands) that will be added to the SmartDashboard
	 */
	public List<Command> getCommands();

	/**
	 * Returns the Default Command that will run on the Subsystem.
	 */
	public Command getIdleCommand();

	/**
	 * Returns a Command Chooser that is added to the SmartDashboard by
	 * SubsystemManager.
	 */
	public default SendableChooser<Command> getCommandChooser()
	{
		SendableChooser<Command> chooser = new SendableChooser<Command>();

		String subsystem = getClass().getSimpleName();

		if(getIdleCommand() != null) {
			chooser.addDefault(subsystem + " Idle", getIdleCommand());
		}
		for (Command state : getCommands()) {
			if(state != null) {
				chooser.addObject(subsystem + " " + state, state);
			}
		}
		
		return chooser;
	}

	/**
	 * Pauses a thread for a given time.
	 * 
	 * @param timeout
	 *            how long to pause the thread
	 */
	public default void sleep(long timeout)
	{
		try
		{
			Thread.sleep(timeout);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Method for reporting a subsystem. Called by SubsystemManager
	 * periodically.
	 */
	public void report();

	/**
	 * Method for reporting what state a particular subsystem was set to.
	 * 
	 * @param state
	 */
	public default void reportState(String state)
	{
		System.out.println("Setting " + getClass().getSimpleName() + " State: " + state);
	}

}