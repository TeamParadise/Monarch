package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.Stateful;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public abstract class StateMachinePID extends PIDSubsystem implements Stateful
{

	public StateMachinePID(String name, double kP, double kI, double kD, double kF)
	{
		super(name, kP, kI, kD, kF);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	public void report()
	{
		if (getName() != null && getCurrentCommand() != null && getCurrentCommand().getName() != null)
			SmartDashboard.putString(getName() + " State", getCurrentCommand().getName());
	}

}
