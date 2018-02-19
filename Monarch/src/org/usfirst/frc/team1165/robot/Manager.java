package org.usfirst.frc.team1165.robot;

import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc.team1165.util.Stateful;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A class that manages subsystems and commands.
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Manager
{
	private static final Manager mInstance = new Manager();

	private Map<Stateful, Command> mCommands = new HashMap<>();

	protected Manager()
	{
	}

	public static Manager getInstance()
	{
		return mInstance;
	}

	/**
	 * Ties a command and a subsystem together
	 * 
	 * @param subsystem subsystem that the command belongs to
	 * @param command the command
	 */
	public void add(Stateful subsystem, Command command)
	{
		mCommands.put(subsystem, command);
	}

	/**
	 * Adds a particular subsystem's commands to the SmartDashboard.
	 * 
	 * @param subsystem
	 */
	public void putCommands(Stateful subsystem)
	{
		mCommands.forEach((this_subsystem, command) ->
		{
			if (this_subsystem.equals(subsystem))
			{
				SmartDashboard.putData(command);
			}
		});
	}

	/**
	 * Adds all the commands to the SmartDashboard.
	 */
	public void putCommands()
	{
		mCommands.values().forEach(SmartDashboard::putData);
	}

	/**
	 * Reports all the subsystems to the SmartDashboard.
	 */
	public void report()
	{
		mCommands.keySet().forEach(Stateful::report);
	}

	/**
	 * Reports a particular subsystem's to the SmartDashboard.
	 * 
	 * @param subsystem
	 */
	public void report(Stateful subsystem)
	{
		mCommands.keySet().forEach((this_subsystem) ->
		{
			if (this_subsystem.equals(subsystem))
			{
				this_subsystem.report();
			}
		});
	}

}