package org.usfirst.frc.team1165.robot.commandgroups.lift;

import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleUp;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftScaleUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftScaleUp extends CommandGroup
{
	public LiftScaleUp()
	{
		addParallel(new LinearLiftScaleUp());
		addParallel(new RotaryLiftScaleUp());
	}
}
