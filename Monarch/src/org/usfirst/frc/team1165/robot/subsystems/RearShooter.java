package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterEject;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIdle;
import org.usfirst.frc.team1165.robot.commands.rear_shooter.RearShooterIntake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RearShooter extends StateMachine
{
	private static final RearShooter mInstance = new RearShooter();

	public synchronized static RearShooter getInstance()
	{
		return mInstance;
	}
	private WPI_TalonSRX mRearRightMotor = new WPI_TalonSRX(RobotMap.REAR_RIGHT_SHOOTER_PORT);

	private WPI_TalonSRX mRearLeftMotor = new WPI_TalonSRX(RobotMap.REAR_LEFT_SHOOTER_PORT);

	protected RearShooter()
	{
//		mRearRightMotor.setInverted(true); // commented out as a test
	}

	public void eject()
	{
//		reportState("Eject");
		mRearRightMotor.set(-1);
		mRearLeftMotor.set(-1);
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> states = new ArrayList<Command>();

		states.add(new RearShooterIntake());
		states.add(new RearShooterEject());

		return states;
	}

	@Override
	public Command getIdleCommand()
	{
		return new RearShooterIdle();
	}

	public void idle()
	{
//		reportState("Idle");
		mRearRightMotor.set(0);
		mRearLeftMotor.set(0);
	}

	public void intake()
	{
//		reportState("Intake");
		mRearRightMotor.set(1);
		mRearLeftMotor.set(1);
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber("Rear Right Shooter", mRearRightMotor.get());
		SmartDashboard.putNumber("Rear Left Shooter", mRearLeftMotor.get());
	}

}