package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private WPI_TalonSRX rightMotor;
	private WPI_TalonSRX leftMotor;

//	private Encoder rightEncoder;
//	private Encoder leftEncoder;
	
	public Shooter()
	{
		rightMotor = new WPI_TalonSRX(RobotMap.RIGHT_SHOOTER_PORT);
		leftMotor = new WPI_TalonSRX(RobotMap.LEFT_SHOOTER_PORT);

		leftMotor.setInverted(true);
		
//		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_PORT_1, RobotMap.RIGHT_ENCODER_PORT_2, false, EncodingType.k4X);
//		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_PORT_1, RobotMap.LEFT_ENCODER_PORT_2, false, EncodingType.k4X);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intake()
    {
    	rightMotor.set(1);
    	leftMotor.set(1);
    }
    
    public void shoot()
    {
    	rightMotor.set(-1);
    	leftMotor.set(-1);
    }
    
    public void stop() {
    	rightMotor.set(0);
    	leftMotor.set(0);
    }
    
    public void report()
    {
//    	SmartDashboard.putNumber("Right Encoder", rightEncoder.get());
//    	SmartDashboard.putNumber("Left Encoder", leftEncoder.get());
    }
}

