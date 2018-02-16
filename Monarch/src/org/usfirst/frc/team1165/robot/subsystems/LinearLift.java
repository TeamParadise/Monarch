package org.usfirst.frc.team1165.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIdle;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftIntake;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleDown;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftScaleUp;
import org.usfirst.frc.team1165.robot.commands.linear_lift.LinearLiftSwitch;

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

	private static final LinearLift mInstance = new LinearLift();

	private WPI_TalonSRX mLinearLiftMotor = new WPI_TalonSRX(RobotMap.LINEAR_LIFT_PORT);

	protected LinearLift()
	{
		super("Linear Lift", 0.1, 0, 0.01, 0);

		resetInputRange(LinearLiftPosition.INTAKE, LinearLiftPosition.SCALE_UP);
		setOutputRange(-0.2, 0.2);
		setAbsoluteTolerance(10);

		getPIDController().setContinuous(false);
	}

	public synchronized static LinearLift getInstance()
	{
		return mInstance;
	}

	public void resetInputRange(LinearLiftPosition down, LinearLiftPosition up)
	{
		setInputRange(down.getValue() - 100, up.getValue() + 100);
	}

	public double getLiftPosition()
	{
		return mLinearLiftMotor.getSensorCollection().getQuadraturePosition();
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
	protected double returnPIDInput()
	{
		return getLiftPosition();
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
	public void report()
	{
		SmartDashboard.putNumber("Linear Lift Motor", mLinearLiftMotor.get());
		SmartDashboard.putNumber("Linear Lift Motor Position", getLiftPosition());

		SmartDashboard.putNumber("Linear Lift Target", getSetpoint());
		SmartDashboard.putBoolean("Linear Lift On Target", onTarget());
	}

}