package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ServoSystem extends Subsystem
{
	private Servo servo;

	public ServoSystem()
	{
		servo = new Servo(RobotMap.SERVO_PORT);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void setServoAngle(double angle) {
    	servo.setAngle(angle);
    }

    public void report()
    {
    	SmartDashboard.putNumber("Servo Angle", servo.getAngle());
    }
}

