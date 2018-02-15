package org.usfirst.frc.team1165.robot.commandgroups.lift;

import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftSwitch;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftSwitch extends CommandGroup
{
	public LiftSwitch()
	{
		addParallel(new LinearLiftSwitch());
		addParallel(new RotaryLiftDown());
	}
}
