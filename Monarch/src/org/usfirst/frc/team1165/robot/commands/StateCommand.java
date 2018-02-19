package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class StateCommand extends Command
{
	public void report()
	{
		System.out.println("Setting State: " + getName());
	}
}