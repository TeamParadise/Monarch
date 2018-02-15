package org.usfirst.frc.team1165.robot.commands.intake;

import org.usfirst.frc.team1165.robot.commands.claw.ClawClose;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterIdle;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIdle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeStore extends CommandGroup
{
	public IntakeStore()
	{
		addParallel(new ClawClose());
		addParallel(new FrontShooterIdle());
		addParallel(new RearShooterIdle());
	}
}
