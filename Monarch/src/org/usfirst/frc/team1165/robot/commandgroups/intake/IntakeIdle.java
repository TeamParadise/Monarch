package org.usfirst.frc.team1165.robot.commandgroups.intake;

import org.usfirst.frc.team1165.robot.commands.claw.ClawIdle;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterIdle;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIdle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeIdle extends CommandGroup
{
	public IntakeIdle()
	{
		addParallel(new ClawIdle());
		addParallel(new FrontShooterIdle());
		addParallel(new RearShooterIdle());
	}
}