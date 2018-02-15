package org.usfirst.frc.team1165.robot.commandgroups.intake;

import org.usfirst.frc.team1165.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterTwistLeft;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIdle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeTwistLeft extends CommandGroup
{
	public IntakeTwistLeft()
	{
		addParallel(new ClawOpen());
		addParallel(new FrontShooterTwistLeft());
		addParallel(new RearShooterIdle());
	}
}
