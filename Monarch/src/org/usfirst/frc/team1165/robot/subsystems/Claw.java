package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.claw.ClawClose;
import org.usfirst.frc.team1165.robot.commands.claw.ClawIdle;
import org.usfirst.frc.team1165.robot.commands.claw.ClawOpen;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * <p>
 * The Claw consists of two pistons, which are controlled by one
 * {@link DoubleSolenoid}.
 * </p>
 * 
 * <p>
 * The Claw has three states:
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
public class Claw extends StateMachine
{
	private static final Claw mInstance = new Claw();

	public synchronized static Claw getInstance()
	{
		return mInstance;
	}

	private DoubleSolenoid mClawSolenoid = new DoubleSolenoid(RobotMap.PCM_1, RobotMap.SOLENOID_ARM_EXTEND_PORT,
			RobotMap.SOLENOID_ARM_RETRACT_PORT);

	protected Claw()
	{
	}

	public void close()
	{
		reportState("Close");
		mClawSolenoid.set(Value.kForward);

		sleep(60);

		mInstance.mClawSolenoid.set(Value.kOff);
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> states = new ArrayList<Command>();

		states.add(new ClawOpen());
		states.add(new ClawClose());

		return states;
	}

	@Override
	public Command getIdleCommand()
	{
		return new ClawIdle();
	}

	public void idle()
	{
		reportState("Idle");
		mInstance.mClawSolenoid.set(Value.kOff);
	}

	public void open()
	{
		reportState("Open");
		mClawSolenoid.set(Value.kReverse);

		sleep(60);

		mInstance.mClawSolenoid.set(Value.kOff);
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Claw Piston", mClawSolenoid.get().toString());
	}
}