
package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.climber_isolate.ClimberIsolateFire;
import org.usfirst.frc.team1165.robot.commands.climber_isolate.ClimberIsolateIdle;
import org.usfirst.frc.team1165.robot.commands.climber_isolate.ClimberIsolateIsolate;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * <p>
 * The ClimberIsolate consists of one {@link DoubleSolenoid} that isolates or
 * powers the Climber. This is part of the system to make the Climber retract
 * faster.
 * </p>
 * 
 * <p>
 * The ClimberIsolate has three states:
 * </p>
 * 
 * <ol>
 * <li>Idle (default)</li>
 * <li>Isolate</li>
 * <li>Fire</li>
 * </ol>
 * 
 * @author Kesav Kadalazhi
 *
 */
public class ClimberIsolate extends StateMachine
{
	private static final ClimberIsolate mInstance = new ClimberIsolate();

	private DoubleSolenoid mClimberIsolateSolenoid = new DoubleSolenoid(RobotMap.PCM_1,
			RobotMap.SOLENOID_CLIMBER_FIRE_PORT, RobotMap.SOLENOID_CLIMBER_ISOLATE_PORT);

	protected ClimberIsolate()
	{
	}

	public void idle()
	{
		reportState("Idle");
		mClimberIsolateSolenoid.set(Value.kOff);
	}

	public void isolate()
	{
		reportState("Isolate");
		mClimberIsolateSolenoid.set(Value.kReverse);
	}

	public void fire()
	{
		reportState("Fire");
		mClimberIsolateSolenoid.set(Value.kForward);
	}

	public synchronized static ClimberIsolate getInstance()
	{
		return mInstance;
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> states = new ArrayList<Command>();

		states.add(new ClimberIsolateIsolate());
		states.add(new ClimberIsolateFire());
		
		return states;
	}

	@Override
	public Command getIdleCommand()
	{
		return new ClimberIsolateIdle();
	}

	@Override
	public void report()
	{
		super.report();

		SmartDashboard.putString("Climber Isolate", mClimberIsolateSolenoid.get().toString());
	}
}
