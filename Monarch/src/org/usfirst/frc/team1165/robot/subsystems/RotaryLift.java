package org.usfirst.frc.team1165.robot.subsystems;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftDown;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftIdle;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftScaleDown;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftScaleUp;
import org.usfirst.frc.team1165.util.RotaryLiftPosition;
import org.usfirst.frc.team1165.util.StateMachinePID;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RotaryLift extends StateMachinePID
{
	private static final RotaryLift mInstance = new RotaryLift();

	// private WPI_TalonSRX mRotaryLiftMotor = new WPI_TalonSRX(RobotMap.ROTARY_LIFT_PORT);
	private WPI_TalonSRX mRotaryLiftMotor = new WPI_TalonSRX(6);

//	private AnalogPotentiometer mPotentiometer = new AnalogPotentiometer(0, 360, 0);
	
	private double mOutput;

	public synchronized static RotaryLift getInstance()
	{
		return mInstance;
	}

	protected RotaryLift()
	{
		super("Rotary Lift", 0.05, 0, 0, 0.01);

		setInputRange(0, 360);
		setOutputRange(-0.1, 0.1);
		setAbsoluteTolerance(5);

		getPIDController().setContinuous();
	}
	
	public double getLiftPosition() {
//		return mPotentiometer.get();
		double angle = mRotaryLiftMotor.getSensorCollection().getQuadraturePosition();
		if(angle >=0)
			return angle % 360;
		return 360- Math.abs(angle  % 360);
	}

	public void setSetpoint(RotaryLiftPosition position)
	{
		setSetpoint(position.getValue());
	}

	public void stop() {
		mRotaryLiftMotor.set(0);
	}

	@Override
	public List<Command> getCommands()
	{
		return Arrays.asList(
			new RotaryLiftIdle(),
			new RotaryLiftDown(),
			new RotaryLiftScaleDown(),
			new RotaryLiftScaleUp());
	}

	@Override
	protected double returnPIDInput()
	{
		return getLiftPosition();
	}
	
	@Override
	protected void usePIDOutput(double output)
	{
		mOutput = output;
		mRotaryLiftMotor.set(output);
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber("Rotary Lift Motor", mRotaryLiftMotor.get());
		SmartDashboard.putNumber("Rotary Lift Position", getLiftPosition());

		SmartDashboard.putNumber("Linear Lift Target", getSetpoint());
		SmartDashboard.putBoolean("Linear Lift On Target", onTarget());
		
		SmartDashboard.putNumber("Linear Lift Output", mOutput);
	}

}