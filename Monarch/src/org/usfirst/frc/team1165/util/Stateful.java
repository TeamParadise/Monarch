package org.usfirst.frc.team1165.util;

/**
 * Common interface for all State Machines.
 * 
 * @author Kesav Kadalazhi
 *
 */
public interface Stateful
{
	/**
	 * Method for reporting a subsystem. Called by SubsystemManager
	 * periodically.
	 */
	public void report();

}