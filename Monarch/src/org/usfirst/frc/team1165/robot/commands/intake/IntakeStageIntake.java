package org.usfirst.frc.team1165.robot.commands.intake;

import org.usfirst.frc.team1165.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterIntake;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeStageIntake extends CommandGroup
{
	public IntakeStageIntake()
	{
		addParallel(new ClawOpen());
		addParallel(new FrontShooterIntake());
		addParallel(new RearShooterIntake());
	}
}
