package org.usfirst.frc.team1165.robot.commandgroups.lift;

import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleDown;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftScaleDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftScaleDown extends CommandGroup
{
	public LiftScaleDown()
	{
		addParallel(new LinearLiftScaleDown());
		addParallel(new RotaryLiftScaleDown());
	}
}
