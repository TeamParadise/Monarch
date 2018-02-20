package org.usfirst.frc.team1165.robot.subsystems;

import static org.usfirst.frc.team1165.robot.RobotMap.ROTARY_LIFT_PORT;
import static org.usfirst.frc.team1165.robot.RobotMap.ROTARY_LIFT_POT_PORT;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftDown;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftIdle;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftScaleDown;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftScaleUp;
import org.usfirst.frc.team1165.util.StateMachinePID;
import org.usfirst.frc.team1165.util.states.RotaryLiftState;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
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

	private WPI_TalonSRX mRotaryLiftMotor = new WPI_TalonSRX(ROTARY_LIFT_PORT);

	private AnalogPotentiometer mPotentiometer = new AnalogPotentiometer(ROTARY_LIFT_POT_PORT, 360, 0);

	private double mOutput;

	protected RotaryLift()
	{
		super("Rotary Lift", 0.05, 0, 0, 0.01);

		setInputRange(0, 360);
		setOutputRange(-0.1, 0.1);
		setAbsoluteTolerance(5);

		getPIDController().setContinuous();
	}

	public synchronized static RotaryLift getInstance()
	{
		return mInstance;
	}

	/**
	 * <p>
	 * Sets the state of the Rotary Lift. States:
	 * </p>
	 * <ol>
	 * <li>Idle is 0 in</li>
	 * <li>Intake is 0 in</li>
	 * <li>Switch is 100 in</li>
	 * <li>Scale Down is 200 in</li>
	 * <li>Scale Up is 300 in</li>
	 * </ul>
	 * <br>
	 * 
	 * @param state the desired state of the Linear Lift
	 */
	public void set(RotaryLiftState state)
	{
		setSetpoint(state.get());
	}

	public void stop()
	{
		mRotaryLiftMotor.set(0);
	}

	public double getLiftPosition()
	{
		return mPotentiometer.get();
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