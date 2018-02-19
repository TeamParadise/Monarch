package org.usfirst.frc.team1165.robot.commands.lift;

import org.usfirst.frc.team1165.robot.commands.LinearLiftCommand;
import org.usfirst.frc.team1165.robot.commands.RotaryLiftCommand;
import org.usfirst.frc.team1165.util.states.LinearLiftState;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftIntake extends CommandGroup
{
	public LiftIntake()
	{
		addParallel(new LinearLiftCommand(LinearLiftState.INTAKE));
		addParallel(new RotaryLiftCommand(RotaryLiftState.DOWN));
	}
}
