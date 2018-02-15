package org.usfirst.frc.team1165.robot.subsystems;

import java.util.List;

import org.usfirst.frc.team1165.util.Stateful;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public abstract class StateMachinePID extends PIDSubsystem implements Stateful
{

	/**
	 * Current state of the subsystem.
	 */
	protected Command state;

	public StateMachinePID(String name, double kP, double kI, double kD, double kF)
	{
		super(name, kP, kI, kD, kF);
	}

	/**
	 * Gets current state of the subsystem.
	 */
	public Command getState()
	{
		return state;
	}

	/**
	 * Gets a list of States(Commands) that will be added to the SmartDashboard
	 */
	public abstract List<Command> getCommands();

	/**
	 * Returns the Default Command that will run on the Subsystem.
	 */
	public abstract Command getIdleCommand();

	/**
	 * Returns a Command Chooser that is added to the SmartDashboard by
	 * SubsystemManager.
	 */
	public SendableChooser<Command> getCommandChooser()
	{
		SendableChooser<Command> chooser = new SendableChooser<Command>();

		String subsystem = getClass().getSimpleName();

		chooser.addDefault(subsystem + " Idle", getIdleCommand());
		for (Command state : getCommands())
			chooser.addObject(subsystem + " " + state, state);

		return chooser;
	}

	/**
	 * Pauses a thread for a given time.
	 * 
	 * @param timeout
	 *            how long to pause the thread
	 */
	public void sleep(long timeout)
	{
		try
		{
			Thread.sleep(timeout);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void initDefaultCommand()
	{
		Command state = getIdleCommand();
		if (getIdleCommand() != null)
			setDefaultCommand(state);
	}

	/**
	 * Method for reporting a subsystem. Called by SubsystemManager
	 * periodically.
	 */
	public abstract void report();

	/**
	 * Method for reporting what state a particular subsystem was set to.
	 * 
	 * @param state
	 */
	public void reportState(String subsystem, String state)
	{
		System.out.println("Setting " + subsystem + " State: " + state);
	}

}
