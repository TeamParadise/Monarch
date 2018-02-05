package org.usfirst.frc.team1165.robot.commands.commandgroups;

import org.usfirst.frc.team1165.robot.commands.AirToKicker;
import org.usfirst.frc.team1165.robot.commands.ExtendKicker;
import org.usfirst.frc.team1165.robot.commands.IsolateKicker;
import org.usfirst.frc.team1165.robot.commands.RetractKicker;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StageCubeGroup extends CommandGroup
{
	public StageCubeGroup()
	{
		addSequential(new RetractKicker());
		addSequential(new WaitCommand(.5));
		addSequential(new AirToKicker());
		addSequential(new WaitCommand(.5));
		addSequential(new IsolateKicker());
		addSequential(new WaitCommand(.5));
		addSequential(new ExtendKicker());
	}
}
