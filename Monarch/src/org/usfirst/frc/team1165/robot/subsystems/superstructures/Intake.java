package org.usfirst.frc.team1165.robot.subsystems.superstructures;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commandgroups.intake.IntakeIdle;
import org.usfirst.frc.team1165.robot.commandgroups.intake.IntakeIntake;
import org.usfirst.frc.team1165.robot.commandgroups.intake.IntakeOpen;
import org.usfirst.frc.team1165.robot.commandgroups.intake.IntakeSpit;
import org.usfirst.frc.team1165.robot.commandgroups.intake.IntakeStageIntake;
import org.usfirst.frc.team1165.robot.commandgroups.intake.IntakeStore;
import org.usfirst.frc.team1165.robot.commandgroups.intake.IntakeTwistLeft;
import org.usfirst.frc.team1165.robot.commandgroups.intake.IntakeTwistRight;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterEject;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIdle;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIntake;
import org.usfirst.frc.team1165.util.Stateful;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Intake implements Stateful
{
	private static final Intake mInstance = new Intake();

	protected Intake()
	{
	}

	public synchronized static Intake getInstance()
	{
		return mInstance;
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> states = new ArrayList<Command>();

		states.add(new IntakeIntake());
		states.add(new IntakeOpen());
		states.add(new IntakeSpit());
		states.add(new IntakeStageIntake());
		states.add(new IntakeStore());
		states.add(new IntakeTwistLeft());
		states.add(new IntakeTwistRight());

		return states;
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
