package org.usfirst.frc.team1165.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{

	public static final int RIGHT_SHOOTER_PORT = 2;
	public static final int LEFT_SHOOTER_PORT = 3;
	
	public static final int SERVO_PORT = 0;

	public static final int RIGHT_ENCODER_PORT_1 = 0;
	public static final int RIGHT_ENCODER_PORT_2 = 1;
	public static final int LEFT_ENCODER_PORT_1 = 2;
	public static final int LEFT_ENCODER_PORT_2 = 3;
	
	public static final int PCM_1 = 1;
	
	public static final int SOLENOID_KICKER_ISOLATED_PORT = 2;
	public static final int SOLENOID_KICKER_AVAILABLE_PORT = 3;
	
	public static final int SOLENOID_ARM_EXTEND_PORT = 4;
	public static final int SOLENOID_ARM_RETRACT_PORT = 5;
	
	public static final int SOLENOID_KICKER_EXTEND_PORT = 6;
	public static final int SOLENOID_KICKER_RETRACT_PORT = 7;

	public static final int JOYSTICK_PORT = 0;

	////////////////////////////////////////// BUTTONS //////////////////////////////////////////
	
	public static final int CLOSE_ARMS_BUTTON = 7;
	public static final int OPEN_ARMS_BUTTON = 8;

	public static final int EXTEND_KICKER_BUTTON = 9;
	public static final int RETRACT_KICKER_BUTTON = 10;

	public static final int SPIT_CUBE_BUTTON = 2;
	
	public static final int EXTEND_CLIMBER_BUTTON = 3;
	public static final int RETRACT_CLIMBER_BUTTON = 4;

	public static final int INTAKE_BUTTON = 11;
	public static final int SHOOT_BUTTON = 12;
	
	public static final int SERVO_BUTTON_1 = 5;
	public static final int SERVO_BUTTON_2 = 6;

}
