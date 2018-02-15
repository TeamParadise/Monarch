package org.usfirst.frc.team1165.robot.commands.lift;

import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIntake;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftIntake extends CommandGroup
{
	public LiftIntake()
	{
		addParallel(new LinearLiftIntake());
		addParallel(new RotaryLiftDown());
	}
}
