package org.usfirst.frc.team1165.robot.subsystems.superstructures;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.commands.intake.IntakeIdle;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeIntake;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeOpen;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeSpit;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeStageIntake;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeStore;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeTwistLeft;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeTwistRight;
import org.usfirst.frc.team1165.util.Stateful;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Intake implements Stateful
{
	private static final Intake mInstance = new Intake();

	public synchronized static Intake getInstance()
	{
		return mInstance;
	}

	protected Intake()
	{
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> commands = new ArrayList<Command>();

		commands.add(new IntakeIntake());
		commands.add(new IntakeOpen());
		commands.add(new IntakeSpit());
		commands.add(new IntakeStageIntake());
		commands.add(new IntakeStore());
		commands.add(new IntakeTwistLeft());
		commands.add(new IntakeTwistRight());

		return commands;
	}

	@Override
	public Command getIdleCommand()
	{
		return new IntakeIdle();
	}

	@Override
	public void report()
	{
	}

}
