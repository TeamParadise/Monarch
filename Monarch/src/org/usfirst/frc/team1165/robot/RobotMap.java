package org.usfirst.frc.team1165.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// MOTOR CONTROLLERS

	public static final int RIGHT_MASTER_DRIVE_PORT = 20;
	public static final int RIGHT_SLAVE_DRIVE_PORT = 21;
	public static final int LEFT_MASTER_DRIVE_PORT = 22;
	public static final int LEFT_SLAVE_DRIVE_PORT = 23;
	
	public static final int FRONT_RIGHT_SHOOTER_PORT = 6;
	public static final int FRONT_LEFT_SHOOTER_PORT = 2;

	public static final int REAR_RIGHT_SHOOTER_PORT = 4;
	public static final int REAR_LEFT_SHOOTER_PORT = 3;

	public static final int LINEAR_LIFT_PORT = 6;
	public static final int ROTARY_LIFT_PORT = 6;

	public static final int SERVO_PORT = 0;

	// SENSORS

	public static final int LINEAR_LIFT_ENCODER_PORT = 0; // placeholder value
	public static final int ROTARY_LIFT_POT_PORT = 0; // placeholder value

	public static final int PRESSURE_SENSOR_PORT = 0;
	
	// PNEUMATICS

	public static final int PCM_1 = 1;

	public static final int SOLENOID_CLIMBER_WHEELS_PORT = 1;

	public static final int SOLENOID_CLIMBER_ISOLATE_PORT = 2;
	public static final int SOLENOID_CLIMBER_FIRE_PORT = 3;

	public static final int SOLENOID_ARM_EXTEND_PORT = 4;
	public static final int SOLENOID_ARM_RETRACT_PORT = 5;

	public static final int SOLENOID_CLIMBER_EXTEND_PORT = 6;
	public static final int SOLENOID_CLIMBER_RETRACT_PORT = 7;

}
