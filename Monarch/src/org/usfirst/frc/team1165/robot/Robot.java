
package org.usfirst.frc.team1165.robot;

import org.usfirst.frc.team1165.robot.commands.ClawCommand;
import org.usfirst.frc.team1165.robot.commands.ClimberPistonCommand;
import org.usfirst.frc.team1165.robot.commands.ClimberWheelsCommand;
import org.usfirst.frc.team1165.robot.commands.ClimberWingsCommand;
import org.usfirst.frc.team1165.robot.commands.FrontShooterCommand;
import org.usfirst.frc.team1165.robot.commands.LinearLiftCommand;
import org.usfirst.frc.team1165.robot.commands.RearShooterCommand;
import org.usfirst.frc.team1165.robot.commands.RotaryLiftCommand;
import org.usfirst.frc.team1165.robot.commands.drive.DriveWithJoystick;
import org.usfirst.frc.team1165.robot.subsystems.Claw;
import org.usfirst.frc.team1165.robot.subsystems.ClimberPiston;
import org.usfirst.frc.team1165.robot.subsystems.ClimberWheels;
import org.usfirst.frc.team1165.robot.subsystems.ClimberWings;
import org.usfirst.frc.team1165.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1165.robot.subsystems.FrontShooter;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;
import org.usfirst.frc.team1165.robot.subsystems.RearShooter;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	private static final SubsystemManager mManager = SubsystemManager.getInstance();

//	private static final Manager manager = Manager.getInstance();
	
	// Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		mManager.add(DriveTrain.getInstance());
		
//		mManager.add(FrontShooter.getInstance());
//		mManager.add(RearShooter.getInstance());
//		mManager.add(Claw.getInstance());
//
//		mManager.add(LinearLift.getInstance());
//		mManager.add(RotaryLift.getInstance());
//		mManager.add(Lift.getInstance());
//
//		mManager.add(ClimberPiston.getInstance());
//		mManager.add(ClimberIsolate.getInstance());
//		mManager.add(ClimberWheels.getInstance());
//
//		mManager.add(Intake.getInstance());
	}

	@Override
	public void robotPeriodic()
	{
		mManager.report();
		
		mManager.putCommands();
	}

	@Override
	public void autonomousInit()
	{
		// schedule the autonomous command (example)
		// if (autonomousCommand != null)
		// autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// if (autonomousCommand != null)
		// autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit()
	{

	}

	@Override
	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic()
	{
		// LiveWindow.run();
	}
}
