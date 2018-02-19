package org.usfirst.frc.team1165.robot;

import java.util.ArrayList;

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
	private static final SubsystemManager mInstance = new SubsystemManager();
	
	private ArrayList<Stateful> mSubsystems = new ArrayList<Stateful>();

	protected SubsystemManager()
	{
	}
	
	public static SubsystemManager getInstance() {
		return mInstance;
	}

	public void add(Stateful subsystem)
	{
		mSubsystems.add(subsystem);
	}

	public void putCommands()
	{
		mSubsystems.forEach((subsystem) -> {
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