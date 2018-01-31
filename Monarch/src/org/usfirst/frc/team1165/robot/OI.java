package org.usfirst.frc.team1165.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1165.robot.commands.CloseArms;
import org.usfirst.frc.team1165.robot.commands.ExtendClimber;
import org.usfirst.frc.team1165.robot.commands.ExtendKicker;
import org.usfirst.frc.team1165.robot.commands.Shoot;
import org.usfirst.frc.team1165.robot.commands.SpitCube;
import org.usfirst.frc.team1165.robot.commands.OpenArms;
import org.usfirst.frc.team1165.robot.commands.RetractClimber;
import org.usfirst.frc.team1165.robot.commands.RetractKicker;
import org.usfirst.frc.team1165.robot.commands.RunServo;
import org.usfirst.frc.team1165.robot.commands.Intake;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	private Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
    
    private Button openArms = new JoystickButton(stick, RobotMap.OPEN_ARMS_BUTTON);
	private Button closeArms = new JoystickButton(stick, RobotMap.CLOSE_ARMS_BUTTON);
    
	private Button extendKicker = new JoystickButton(stick, RobotMap.EXTEND_KICKER_BUTTON);
	private Button retractKicker = new JoystickButton(stick, RobotMap.RETRACT_KICKER_BUTTON);
	
	private Button spitCube = new JoystickButton(stick, RobotMap.SPIT_CUBE_BUTTON);
    
	private Button extendClimber = new JoystickButton(stick, RobotMap.EXTEND_CLIMBER_BUTTON);
	private Button retractClimber = new JoystickButton(stick, RobotMap.RETRACT_CLIMBER_BUTTON);
    
    private Button intake = new JoystickButton(stick, RobotMap.INTAKE_BUTTON);
    private Button shoot = new JoystickButton(stick, RobotMap.SHOOT_BUTTON);
    
    private Button servoButton1 = new JoystickButton(stick, RobotMap.SERVO_BUTTON_1);
    private Button servoButton2 = new JoystickButton(stick, RobotMap.SERVO_BUTTON_2);
    
    public OI()
    {
    	openArms.whenPressed(new OpenArms());
    	closeArms.whenPressed(new CloseArms());
    	
    	extendKicker.whenPressed(new ExtendKicker());
    	retractKicker.whenPressed(new RetractKicker());
    	
    	spitCube.whenPressed(new SpitCube()); // for brennen/luke
    	
    	extendClimber.whenPressed(new ExtendClimber());
    	retractClimber.whenPressed(new RetractClimber()); // for zach
    	
    	intake.whenPressed(new Intake());
    	shoot.whenPressed(new Shoot());
    	
    	servoButton1.whenPressed(new RunServo(60));
    	servoButton2.whenPressed(new RunServo(120));
    }
    
    public boolean intakeButton() {
    	return intake.get();
    }
    
    public boolean shootButton() {
    	return shoot.get();
    }
    
    public boolean spitCubeButton() {
    	return spitCube.get();
    }
    
    public void report()
    {
//    	SmartDashboard.putBoolean("Extend Button", closeArms.get());
//    	SmartDashboard.putBoolean("Retract Button", openArms.get());
//
//    	SmartDashboard.putBoolean("Shoot Button", shoot.get());
    }
}

