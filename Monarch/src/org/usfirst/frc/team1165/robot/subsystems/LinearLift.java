package org.usfirst.frc.team1165.robot.subsystems;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIdle;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIntake;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleDown;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleUp;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftSwitch;
import org.usfirst.frc.team1165.util.LinearLiftPosition;
import org.usfirst.frc.team1165.util.StateMachinePID;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class LinearLift extends StateMachinePID
{
	private static final LinearLift mInstance = new LinearLift();

	private WPI_TalonSRX mLinearLiftMotor = new WPI_TalonSRX(RobotMap.LINEAR_LIFT_PORT);

	protected LinearLift()
	{
		super("Linear Lift", 0.01, 0, 0, 0);

		setInputRange(-10, 65);
		setOutputRange(-0.3, 0.3);
		setAbsoluteTolerance(10);
		
//		mLinearLiftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	}

	public synchronized static LinearLift getInstance()
	{
		return mInstance;
	}

	/**
	 * 
	 * <p>
	 * in = ticks * (1 rev)/(12 ticks) * (1.751 * pi in)/(1 rev) * gear_ratio<br>
	 * in = (ticks * pi * 1.751 * gear_ratio) / 912 ticks)
	 * </p>
	 */
	public double getLiftPosition()
	{
		return mLinearLiftMotor.getSensorCollection().getQuadraturePosition();
//		return (mLinearLiftMotor.getSensorCollection().getQuadraturePosition() * Math.PI * 1.751 * 4) / 12;
	}

	public void setSetpoint(LinearLiftPosition position)
	{
		setSetpoint(position.get());
	}

	@Override
	public List<Command> getCommands()
	{
		return Arrays.asList(new LinearLiftIdle(), new LinearLiftIntake(), new LinearLiftIdle(), new LinearLiftSwitch(),
				new LinearLiftScaleDown(), new LinearLiftScaleUp());
	}

	@Override
	protected double returnPIDInput()
	{
		return getLiftPosition();
	}

	@Override
	protected void usePIDOutput(double output)
	{
		mLinearLiftMotor.set(-output);
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber("Linear Lift Motor", mLinearLiftMotor.get());
		SmartDashboard.putNumber("Linear Lift Motor Position", getLiftPosition());

		SmartDashboard.putNumber("Linear Lift Target", getSetpoint());
		SmartDashboard.putBoolean("Linear Lift On Target", onTarget());
	}

}