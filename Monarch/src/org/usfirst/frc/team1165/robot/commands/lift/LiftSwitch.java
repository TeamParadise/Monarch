package org.usfirst.frc.team1165.robot.commands.lift;

import org.usfirst.frc.team1165.robot.commands.LinearLiftCommand;
import org.usfirst.frc.team1165.robot.commands.RotaryLiftCommand;
import org.usfirst.frc.team1165.util.states.LinearLiftState;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftSwitch extends CommandGroup
{
	public LiftSwitch()
	{
		addParallel(new LinearLiftCommand(LinearLiftState.SWITCH));
		addParallel(new RotaryLiftCommand(RotaryLiftState.DOWN));
	}
}
