package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftDown;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftIdle;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftScaleDown;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RotaryLiftPID extends StateMachinePID
{
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

	private static final RotaryLiftPID mInstance = new RotaryLiftPID();

	// private Encoder mEncoder = new Encoder(0, 0, false, EncodingType.k4X);

	public synchronized static RotaryLiftPID getInstance()
	{
		return mInstance;
	}

	// private WPI_TalonSRX mRotaryLiftMotor = new
	// WPI_TalonSRX(RobotMap.ROTARY_LIFT_PORT);
	private WPI_TalonSRX mRotaryLiftMotor = new WPI_TalonSRX(6);

	protected RotaryLiftPID()
	{
		super("Rotary Lift", 0.01, 0, 0, 0);

		setInputRange(0, 360);
		setOutputRange(-0.25, 0.25);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous();
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> commands = new ArrayList<Command>();

		commands.add(new RotaryLiftDown());
		commands.add(new RotaryLiftIdle());
		commands.add(new RotaryLiftScaleDown());

		return commands;
	}

	@Override
	public Command getIdleCommand()
	{
		return new RotaryLiftIdle();
	}

	@Override
	public void report()
	{
		SmartDashboard.putNumber("Rotary Lift Motor", mRotaryLiftMotor.get());
		SmartDashboard.putNumber("Rotary Lift Motor", returnPIDInput());
	}

	@Override
	protected double returnPIDInput()
	{
		return mRotaryLiftMotor.getSensorCollection().getQuadraturePosition() % 360;
		// return mEncoder.get() % 360;
	}

	public void setSetpoint(RotaryLiftPosition position)
	{
		setSetpoint(position.getValue());
	}

	@Override
	protected void usePIDOutput(double output)
	{
		mRotaryLiftMotor.set(output);
	}

}