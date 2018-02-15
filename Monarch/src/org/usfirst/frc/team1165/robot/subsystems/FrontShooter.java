package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterEject;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterIdle;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterIntake;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterTwistLeft;
import org.usfirst.frc.team1165.robot.commands.front_shooter.FrontShooterTwistRight;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class FrontShooter extends StateMachine
{
	private static final FrontShooter mInstance = new FrontShooter();

	private WPI_TalonSRX mFrontRightMotor = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_SHOOTER_PORT);
	private WPI_TalonSRX mFrontLeftMotor = new WPI_TalonSRX(RobotMap.FRONT_LEFT_SHOOTER_PORT);

	protected FrontShooter()
	{
		mFrontRightMotor.setInverted(true);
	}

	public void idle()
	{
		reportState("Idle");
		mFrontRightMotor.set(0);
		mFrontLeftMotor.set(0);
	}

	public void intake()
	{
		reportState("Intake");
		mFrontRightMotor.set(1);
		mFrontLeftMotor.set(1);
	}

	public void eject()
	{
		reportState("Eject");
		mFrontRightMotor.set(-1);
		mFrontLeftMotor.set(-1);
	}

	public void twistRight()
	{
		reportState("Twist Right");
		mFrontRightMotor.set(1);
		mFrontLeftMotor.set(-1);
	}

	public void twistLeft()
	{
		reportState("Twist Left");
		mFrontRightMotor.set(-1);
		mFrontLeftMotor.set(1);
	}

	public synchronized static FrontShooter getInstance()
	{
		return mInstance;
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> states = new ArrayList<Command>();

		states.add(new FrontShooterIntake());
		states.add(new FrontShooterEject());
		states.add(new FrontShooterTwistRight());
		states.add(new FrontShooterTwistLeft());

		return states;
	}

	@Override
	public Command getIdleCommand()
	{
		return new FrontShooterIdle();
	}

	@Override
	public void report()
	{
		super.report();

		SmartDashboard.putNumber("Front Right Shooter", mFrontRightMotor.get());
		SmartDashboard.putNumber("Front Left Shooter", mFrontLeftMotor.get());
	}

}
