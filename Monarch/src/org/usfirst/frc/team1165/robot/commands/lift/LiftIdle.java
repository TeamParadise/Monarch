package org.usfirst.frc.team1165.robot.commands.lift;

import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIdle;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftIdle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftIdle extends CommandGroup
{
	public LiftIdle()
	{
		addParallel(new LinearLiftIdle());
		addParallel(new RotaryLiftIdle());
	}
}
