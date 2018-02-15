package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class StateCommand extends Command
{
	@Override
	protected void interrupted()
	{
		end();
	}

	public void report()
	{
//		System.out.println("Setting " + getSubsystem() + " State: " + getName());
		System.out.println("Setting State: " + getName());
	}
}