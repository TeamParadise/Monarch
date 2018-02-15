package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.climber_wheels.ClimberWheelsDisengage;
import org.usfirst.frc.team1165.robot.commands.climber_wheels.ClimberWheelsEngage;
import org.usfirst.frc.team1165.robot.commands.climber_wheels.ClimberWheelsIdle;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * <p>
 * The ClimberWheels consists of two stops at the back of the robot that are let
 * out
 * </p>
 * 
 * <p>
 * The ClimberWheels has three states:
 * </p>
 * 
 * <ol>
 * <li>Idle (default)</li>
 * <li>Open</li>
 * <li>Close</li>
 * </ol>
 * 
 * @author Kesav Kadalazhi
 *
 */
public class ClimberWheels extends StateMachine
{
	private static final ClimberWheels mInstance = new ClimberWheels();

	public synchronized static ClimberWheels getInstance()
	{
		return mInstance;
	}

	private Solenoid mClimberWheelsSolenoid = new Solenoid(RobotMap.PCM_1, RobotMap.SOLENOID_CLIMBER_WHEELS_PORT);

	protected ClimberWheels()
	{
	}

	public void disengage()
	{
		reportState("Disengage");
		mClimberWheelsSolenoid.set(false);
	}

	public void engage()
	{
		reportState("Engage");
		mClimberWheelsSolenoid.set(true);
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> states = new ArrayList<Command>();

		states.add(new ClimberWheelsEngage());
		states.add(new ClimberWheelsDisengage());

		return states;
	}

	@Override
	public Command getIdleCommand()
	{
		return new ClimberWheelsIdle();
	}

	public void idle()
	{
		reportState("Idle");
		mClimberWheelsSolenoid.set(false);
	}

	@Override
	public void report()
	{
		SmartDashboard.putBoolean("Climber Wheels Piston", mClimberWheelsSolenoid.get());
	}
}