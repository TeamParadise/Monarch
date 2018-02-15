package org.usfirst.frc.team1165.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc.team1165.robot.commands.intake.IntakeIdle;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeIntake;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeOpen;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeSpit;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeStageIntake;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeStore;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeTwistLeft;
import org.usfirst.frc.team1165.robot.commands.intake.IntakeTwistRight;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @author Kesav Kadalazhi
 */
public class OI
{
	// private Joystick stick = new Joystick(1);

	// /*
	private XboxController mController = new XboxController(1);

	private JoystickButton mButtonA = new JoystickButton(mController, 1);
	private JoystickButton mButtonB = new JoystickButton(mController, 2);
	private JoystickButton mButtonX = new JoystickButton(mController, 3);
	private JoystickButton mButtonY = new JoystickButton(mController, 4);
	private JoystickButton mButtonLB = new JoystickButton(mController, 5);
	private JoystickButton mButtonRB = new JoystickButton(mController, 6);
	private JoystickButton mButtonLeftStick = new JoystickButton(mController, 9);
	private JoystickButton mButtonRightStick = new JoystickButton(mController, 10);

	public OI()
	{
		// mButtonA.whenPressed(new FrontShooterIdle());
		// mButtonB.whenPressed(new FrontShooterIntake());
		// mButtonX.whenPressed(new FrontShooterEject());
		// mButtonY.whenPressed(new FrontShooterTwistRight());
		// mButtonLB.whenPressed(new FrontShooterTwistLeft());

		// mButtonA.whenPressed(new RearShooterIdle());
		// mButtonB.whenPressed(new RearShooterIntake());
		// mButtonX.whenPressed(new RearShooterEject());

		// mButtonA.whenPressed(new ClawIdle());
		// mButtonB.whenPressed(new ClawOpen()); // extend
		// mButtonX.whenPressed(new ClawClose()); // retract

		// mButtonY.whenPressed(new ClimberPistonIdle());
		// mButtonLB.whenPressed(new ClimberPistonExtend());
		// mButtonRB.whenPressed(new ClimberPistonRetract());
		//
		// mButtonY.whenPressed(new ClimberIsolateIdle());
		// mButtonLB.whenPressed(new ClimberIsolateIsolate());
		// mButtonRB.whenPressed(new ClimberIsolateFire());

		mButtonA.whenPressed(new IntakeIdle());
		mButtonB.whenPressed(new IntakeIntake());
		mButtonX.whenPressed(new IntakeOpen());
		mButtonY.whenPressed(new IntakeSpit());
		mButtonLB.whenPressed(new IntakeStageIntake());
		mButtonRB.whenPressed(new IntakeStore());
		mButtonLeftStick.whenPressed(new IntakeTwistLeft());
		mButtonRightStick.whenPressed(new IntakeTwistRight());
		//
		// mButtonY.whenPressed(new ExecuteState(ClimberWheelsState.IDLE));
		// mButtonLB.whenPressed(new ExecuteState(ClimberWheelsState.ENGAGE));
		// mButtonRB.whenPressed(new
		// ExecuteState(ClimberWheelsState.DISENGAGE));
		//
		// mButtonLeftStick.whenPressed(new ExecuteState(IntakeState.STORE));
		// mButtonRightStick.whenPressed(new ExecuteState(IntakeState.SPIT));
	}

	public double dampen(double value)
	{
		double damped = Math.pow(value, 3);
		return Math.abs(damped) < 0.1 ? 0 : damped;
	}

	public double getLeftY()
	{
		return dampen(-mController.getY(Hand.kLeft));
	}

	// */
	public double getRightY()
	{
		return dampen(mController.getY(Hand.kRight));
	}

	public double getTwist()
	{
		return 0;
		// return dampen(stick.getTwist());
	}

	public void report()
	{
		SmartDashboard.putNumber("Controller Right Y", getRightY());
		SmartDashboard.putNumber("Controller Left Y", getLeftY());
	}

	// public void report()
	// {
	// SmartDashboard.putNumber("OI X", getX());
	// SmartDashboard.putNumber("OI Y", getY());
	// SmartDashboard.putNumber("OI Twist", getTwist());
	// }

}
