package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIntake;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIdle;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleDown;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleUp;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftSwitch;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class LinearLiftPID extends StateMachinePID
{
	private static final LinearLiftPID mInstance = new LinearLiftPID();

	private WPI_TalonSRX mLinearLiftMotor = new WPI_TalonSRX(RobotMap.LINEAR_LIFT_PORT);

	private Encoder mEncoder = new Encoder(0, 0, false, EncodingType.k4X);

	public enum LinearLiftPosition
	{
		IDLE(0), INTAKE(0), SWITCH(100), SCALE_DOWN(200), SCALE_UP(300);

		private int value;

		LinearLiftPosition(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}
	}

	protected LinearLiftPID()
	{
		super("Linear Lift", 0.01, 0, 0, 0);

		resetInputRange(LinearLiftPosition.INTAKE, LinearLiftPosition.SCALE_UP); // placeholder value
		setOutputRange(-0.25, 0.25);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous(false);
	}

	public synchronized static LinearLiftPID getInstance()
	{
		return mInstance;
	}
	
	public void resetInputRange(LinearLiftPosition down, LinearLiftPosition up) {
		setInputRange(down.getValue() - 100, up.getValue() + 100);
	}

	public double getPosition()
	{
		return mEncoder.get();
	}

	@Override
	protected double returnPIDInput()
	{
		return getPosition();
	}

	@Override
	protected void usePIDOutput(double output)
	{
		mLinearLiftMotor.set(output);
	}

	public void setSetpoint(LinearLiftPosition position)
	{
		setSetpoint(position.getValue());
	}

	@Override
	public List<Command> getCommands()
	{
		List<Command> commands = new ArrayList<Command>();

		commands.add(new LinearLiftIntake());
		commands.add(new LinearLiftIdle());
		commands.add(new LinearLiftSwitch());
		commands.add(new LinearLiftScaleDown());
		commands.add(new LinearLiftScaleUp());

		return commands;
	}

	@Override
	public Command getIdleCommand()
	{
		return new LinearLiftIdle();
	}

	@Override
	public void report()
	{
		super.report();

		SmartDashboard.putNumber("Linear Lift Motor", mLinearLiftMotor.get());
		SmartDashboard.putNumber("Linear Lift Motor Position", getPosition());
	}

}
