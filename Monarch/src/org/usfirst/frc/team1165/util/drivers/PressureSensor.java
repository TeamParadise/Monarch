package org.usfirst.frc.team1165.util.drivers;

import static org.usfirst.frc.team1165.robot.RobotMap.PRESSURE_SENSOR_PORT;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Wraps an analog input for a Rev Robotics Analog Pressure sensor.
 *
 * http://www.revrobotics.com/wp-content/uploads/2015/11/REV-11-1107-DS-00.pdf
 */
public class PressureSensor
{
	private static final AnalogInput mPressureSensor = new AnalogInput(PRESSURE_SENSOR_PORT);

	/**
	 * Calculates the pressure in the system.
	 * 
	 * @return pressure of the system
	 */
	public static double getPressure()
	{
		/*
		 * Equation:
		 * 
		 * v_out = mAnalogInput.getVoltage() v0 = voltage at 60 psi
		 * 
		 * p = 85(v_out/v0) - 25
		 */
		return 50 * mPressureSensor.getVoltage() - 25;
	}

	public void report()
	{
		SmartDashboard.putNumber("Pressure Sensor Value", getPressure());
	}

}
