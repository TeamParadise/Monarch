package org.usfirst.frc.team1165.robot;

import java.util.ArrayList;

import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston;
import org.usfirst.frc.team1165.util.Stateful;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class SubsystemManager
{
	private ArrayList<Stateful> mSubsystems = new ArrayList<Stateful>();

	private ArrayList<SendableChooser<Command>> mChoosers = new ArrayList<SendableChooser<Command>>();

	public SubsystemManager()
	{
		// add(FrontShooter.getInstance());
		// add(RearShooter.getInstance());
		// add(Claw.getInstance());

		// add(LinearLiftPID.getInstance());
		// add(RotaryLiftPID.getInstance());
		// add(Lift.getInstance());

		add(ClimberPiston.getInstance());
		// add(ClimberIsolate.getInstance());
		// add(ClimberWheels.getInstance());
		
//		add(Intake.getInstance());
	}

	public void add(Stateful subsystem)
	{
		mSubsystems.add(subsystem);
		mChoosers.add(subsystem.getCommandChooser());
	}

	public void report()
	{
		mSubsystems.forEach((s) -> s.report());
	}

	public void putCommandChooser()
	{
		mChoosers.forEach((chooser) -> SmartDashboard.putData(chooser));
	}

	public void putSelectedCommand()
	{
		mChoosers.forEach((chooser) ->
		{
			SmartDashboard.putData("Execute", new Command()
			{
				public void initialize()
				{
					chooser.getSelected().start();
				}

				protected boolean isFinished()
				{
					return true;
				}
			});
		});
	}

}
