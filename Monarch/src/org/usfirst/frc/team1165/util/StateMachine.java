package org.usfirst.frc.team1165.util;

import edu.wpi.first.wpilibj.command.Subsystem;

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
	protected void initDefaultCommand()
	{
	}
}