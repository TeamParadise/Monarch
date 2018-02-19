package org.usfirst.frc.team1165.robot.subsystems;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.climber_isolate.ClimberIsolateFire;
import org.usfirst.frc.team1165.robot.commands.climber_isolate.ClimberIsolateIdle;
import org.usfirst.frc.team1165.robot.commands.climber_isolate.ClimberIsolateIsolate;
import org.usfirst.frc.team1165.util.StateMachine;

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

	public synchronized static ClimberIsolate getInstance()
	{
		return mInstance;
	}

	public void set(Value position)
	{
		mClimberIsolateSolenoid.set(position);
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

	@Override
	public List<Command> getCommands()
	{
		return Arrays.asList(new ClimberIsolateIdle(), new ClimberIsolateIsolate(), new ClimberIsolateFire());
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Climber Isolate", mClimberIsolateSolenoid.get().toString());
	}
}