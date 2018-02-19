package org.usfirst.frc.team1165.robot.subsystems;

import static org.usfirst.frc.team1165.robot.RobotMap.LINEAR_LIFT_PORT;

import org.usfirst.frc.team1165.util.StateMachinePID;
import org.usfirst.frc.team1165.util.states.LinearLiftState;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class LinearLift extends StateMachinePID
{
	private static final LinearLift mInstance = new LinearLift();

	private WPI_TalonSRX mLinearLiftMotor = new WPI_TalonSRX(LINEAR_LIFT_PORT);

	protected LinearLift()
	{
		super("Linear Lift", 0.01, 0, 0, 0);

		setInputRange(-10, 65);
		setOutputRange(-0.3, 0.3);
		setAbsoluteTolerance(10);
	}

	public synchronized static LinearLift getInstance()
	{
		return mInstance;
	}

	public void set(LinearLiftState state)
	{
		setSetpoint(state.get());
	}

	/**
	 * <p>
	 * Converts the ticks returned from the 775pro Encoder to inches.
	 * </p>
	 * 
	 * @return the position of the linear lift
	 */
	public double getLiftPosition()
	{
		return mLinearLiftMotor.getSensorCollection().getQuadraturePosition();

		/*
		 * in = ticks * (1 rev)/(12 ticks) * (1.751 * pi in)/(1 rev) *
		 * gear_ratio<br>
		 * in = (ticks * pi * 1.751 * gear_ratio) / 12 ticks)
		 */
		// return (mLinearLiftMotor.getSensorCollection().getQuadraturePosition() * Math.PI * 1.751 * 4) / 12;
	}

	@Override
	protected double returnPIDInput()
	{
		return getLiftPosition();
	}

	@Override
	protected void usePIDOutput(double output)
	{
		mLinearLiftMotor.set(output);
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