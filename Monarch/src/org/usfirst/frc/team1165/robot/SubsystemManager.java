package org.usfirst.frc.team1165.robot;

import java.util.ArrayList;

import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;
import org.usfirst.frc.team1165.util.Stateful;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class SubsystemManager
{
	private ArrayList<Stateful> mSubsystems = new ArrayList<Stateful>();

	public SubsystemManager()
	{
		// add(FrontShooter.getInstance());
//		 add(RearShooter.getInstance());
//		 add(Claw.getInstance());

//		 add(LinearLift.getInstance());
		 add(RotaryLift.getInstance());
		// add(Lift.getInstance());

//		add(ClimberPiston.getInstance());
		// add(ClimberIsolate.getInstance());
		// add(ClimberWheels.getInstance());

		// add(Intake.getInstance());
	}

	public void add(Stateful subsystem)
	{
		mSubsystems.add(subsystem);
	}

	public void putCommands()
	{
		mSubsystems.forEach((subsystem) -> {
			SmartDashboard.putData(subsystem.getIdleCommand());
			subsystem.getCommands().forEach(SmartDashboard::putData);
		});
	}

	public void report()
	{
		mSubsystems.forEach((subsystem) -> {
			SmartDashboard.putData((Sendable) subsystem);
			subsystem.report();
		});
	}

}