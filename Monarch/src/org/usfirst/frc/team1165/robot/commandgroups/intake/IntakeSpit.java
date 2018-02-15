package org.usfirst.frc.team1165.robot.commandgroups.intake;

import org.usfirst.frc.team1165.robot.commands.claw.ClawClose;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterEject;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterEject;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeSpit extends CommandGroup
{
	public IntakeSpit()
	{
		addParallel(new ClawClose());
		addParallel(new FrontShooterEject());
		addParallel(new RearShooterEject());
	}
}
