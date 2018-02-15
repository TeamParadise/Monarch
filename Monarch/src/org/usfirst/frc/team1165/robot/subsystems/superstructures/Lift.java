package org.usfirst.frc.team1165.robot.subsystems.superstructures;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIdle;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIntake;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleDown;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleUp;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftSwitch;
import org.usfirst.frc.team1165.util.Stateful;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Lift implements Stateful
{
	private static final Lift mInstance = new Lift();

	public synchronized static Lift getInstance()
	{
		return mInstance;
	}

	protected Lift()
	{
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> commands = new ArrayList<Command>();

		commands.add(new LinearLiftIntake());
		commands.add(new LinearLiftScaleDown());
		commands.add(new LinearLiftScaleUp());
		commands.add(new LinearLiftSwitch());

		return commands;
	}

	@Override
	public Command getIdleCommand()
	{
		return new LinearLiftIdle();
	}

	@Override
	public void report()
	{
	}

}
