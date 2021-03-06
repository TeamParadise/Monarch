package org.usfirst.frc.team1165.robot.commands.lift;

import org.usfirst.frc.team1165.robot.commands.LinearLiftCommand;
import org.usfirst.frc.team1165.robot.commands.RotaryLiftCommand;

import org.usfirst.frc.team1165.util.states.LinearLiftState;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftScaleUp extends CommandGroup
{
	public LiftScaleUp()
	{
		addParallel(new LinearLiftCommand(LinearLiftState.SCALE_UP));
		addParallel(new RotaryLiftCommand(RotaryLiftState.SCALE_UP));
	}
}
