package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.util.Stateful;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * <p>
 * As the parent class of all subsystems, StateMachine defines the base
 * capability of all subsystems.
 * </p>
 * 
 * @author Kesav Kadalazhi
 */
public abstract class StateMachine extends Subsystem implements Stateful
{
	protected StateMachine()
	{
	}

	@Override
	public void initDefaultCommand()
	{
	}
}