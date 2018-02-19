package org.usfirst.frc.team1165.robot.subsystems;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.claw.ClawClose;
import org.usfirst.frc.team1165.robot.commands.claw.ClawIdle;
import org.usfirst.frc.team1165.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team1165.util.StateMachine;

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

	private DoubleSolenoid mClawSolenoid = new DoubleSolenoid(RobotMap.PCM_1, RobotMap.SOLENOID_ARM_EXTEND_PORT,
			RobotMap.SOLENOID_ARM_RETRACT_PORT);

	protected Claw()
	{
	}

	public synchronized static Claw getInstance()
	{
		return mInstance;
	}

	public void set(Value position) {
		mClawSolenoid.set(position);
	}

	@Override
 	public List<Command> getCommands()
	{
		return Arrays.asList(
			new ClawIdle(),
			new ClawOpen(),
			new ClawClose());
	}

	@Override
	public void report()
	{
		SmartDashboard.putString("Claw Piston", mClawSolenoid.get().toString());
	}
}