package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.climber_piston.ClimberPistonExtend;
import org.usfirst.frc.team1165.robot.commands.climber_piston.ClimberPistonIdle;
import org.usfirst.frc.team1165.robot.commands.climber_piston.ClimberPistonRetract;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * <p>
 * The ClimberPiston consists of the piston that retracts the Climber, which is
 * controlled by a {@link DoubleSolenoid}.
 * </p>
 * 
 * <p>
 * The ClimberPiston has three states:
 * </p>
 * 
 * <ol>
 * <li>Idle (default)</li>
 * <li>Extend</li>
 * <li>Retract</li>
 * </ol>
 * 
 * @author Kesav Kadalazhi
 *
 */
public class ClimberPiston extends StateMachine
{
	private static final ClimberPiston mInstance = new ClimberPiston();

	public synchronized static ClimberPiston getInstance()
	{
		return mInstance;
	}

	private DoubleSolenoid mClimberSolenoid = new DoubleSolenoid(RobotMap.PCM_1, RobotMap.SOLENOID_CLIMBER_EXTEND_PORT,
			RobotMap.SOLENOID_CLIMBER_RETRACT_PORT);

	protected ClimberPiston()
	{
	}

	public void extend()
	{
		reportState("Extend");
		mClimberSolenoid.set(Value.kForward);
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> states = new ArrayList<Command>();

		states.add(new ClimberPistonExtend());
		states.add(new ClimberPistonRetract());

		return states;
	}

	@Override
	public Command getIdleCommand()
	{
		return new ClimberPistonIdle();
	}

	public void idle()
	{
		reportState("Idle");
		mClimberSolenoid.set(Value.kOff);
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Climber Piston", mClimberSolenoid.get().toString());
	}

	public void retract()
	{
		reportState("Retract");
		mClimberSolenoid.set(Value.kReverse);
	}
}