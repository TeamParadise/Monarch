package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftDown;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftIdle;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftScaleDown;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftScaleUp;

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
	
	/**
	 * <p>
	 * The Rotary Lift has 4 states:
	 * </p>
	 * 
	 * <ol>
	 * <li>Intake: parallel to the ground</li>
	 * <li>Switch: parallel to the ground</li>
	 * <li>Scale Down: a little higher than the ground</li>
	 * <li>Scale Up: 45 from the ground</li>
	 * </ol>
	 */
	public enum RotaryLiftPosition
	{
		IDLE(0), DOWN(0), SCALE_DOWN(22.5), SCALE_UP(45);

		private double value;

		RotaryLiftPosition(double value)
		{
			this.value = value;
		}

		public double getValue()
		{
			return value;
		}
	}

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

	@Override
	public List<Command> getCommands()
	{
		List<Command> commands = new ArrayList<Command>();

		commands.add(new RotaryLiftDown());
		commands.add(new RotaryLiftIdle());
		commands.add(new RotaryLiftScaleDown());
		commands.add(new RotaryLiftScaleUp());

		return commands;
	}

	@Override
	public Command getIdleCommand()
	{
		return new RotaryLiftIdle();
	}
	
	public double getLiftPosition() {
		return mRotaryLiftMotor.getSensorCollection().getQuadraturePosition() % 360;
//		return mPotentiometer.get();
	}

	@Override
	protected double returnPIDInput()
	{
		return getLiftPosition();
	}

	public void setSetpoint(RotaryLiftPosition position)
	{
		setSetpoint(position.getValue());
	}

	public void stop() {
		mRotaryLiftMotor.set(0);
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