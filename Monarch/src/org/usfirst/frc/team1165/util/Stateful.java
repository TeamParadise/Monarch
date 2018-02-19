package org.usfirst.frc.team1165.util;

import java.util.List;

import edu.wpi.first.wpilibj.command.Command;

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
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}